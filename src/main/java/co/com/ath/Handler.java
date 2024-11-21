package co.com.ath;

import co.com.ath.model.ParameterStore;
import co.com.ath.model.Request;
import co.com.ath.service.DynamoService;
import co.com.ath.service.ParameterStoreService;
import co.com.ath.util.BuildResponseUtil;
import co.com.ath.util.Util;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    // Servicio para obtener parámetros de la tienda de parámetros (Parameter Store)
    ParameterStoreService parameterStoreService = new ParameterStoreService();
    // Obtenemos la configuración de DynamoDB desde Parameter Store
    ParameterStore parameterStore = parameterStoreService.getParameter();

    // Variable para capturar los errores de las excepciones
    StringWriter errors;

    /**
     * Método principal que maneja la solicitud entrante.
     * Este método se invoca cuando Lambda recibe una solicitud API Gateway.
     *
     * @param input Solicitud de API Gateway que contiene el cuerpo y encabezados.
     * @param context Contexto de ejecución de la función Lambda.
     * @return La respuesta generada para la solicitud API Gateway.
     */
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        log.info("Recibiendo parámetros de configuración: " + Util.object2String(parameterStore));

        try {
            // Procesamos la solicitud y generamos una respuesta exitosa
            return BuildResponseUtil.buildSucces(redict(input));
        } catch (Exception e) {
            // Capturamos cualquier excepción, la registramos en los logs y devolvemos un error
            errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            log.error("Se produjo un error durante el procesamiento de la solicitud: " + errors.toString());
        }

        // En caso de error, retornamos una respuesta nula
        return null;
    }

    /**
     * Método que redirige según el tipo de solicitud recibida en el encabezado 'servicio'.
     * Si el servicio es "guardar", se invoca el servicio de DynamoDB para guardar la información.
     *
     * @param input Solicitud de API Gateway que contiene el cuerpo y los encabezados.
     * @return Mensaje indicando el resultado de la operación.
     */
    public Object redict(APIGatewayProxyRequestEvent input) {
        if (input != null) {
            // Obtenemos el valor del encabezado "servicio"
            String header = input.getHeaders().get("servicio");

            if (header != null && header.equalsIgnoreCase("guardar")) {
                // Si el servicio es "guardar", procesamos la solicitud y guardamos los datos en DynamoDB
                DynamoService service = new DynamoService();
                Request request = (Request) Util.string2Object(input.getBody(), Request.class);

                // Guardamos la información usando el servicio DynamoService
                service.guardar(request, parameterStore);
                log.info("La operación de guardado en DynamoDB se completó con éxito.");

                return "Se guardó correctamente en DynamoDB.";
            }

        } else {
            // Si la solicitud no contiene datos, retornamos un mensaje de error
            log.warn("La solicitud de entrada está vacía.");
            return "La solicitud de entrada está vacía.";
        }

        // Si no se reconoce el servicio, devolvemos null
        return null;
    }
}
