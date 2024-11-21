package co.com.ath.util;

import co.com.ath.constants.ConstantsEnum;
import co.com.ath.model.ResponseDto;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

/**
 * Utilidad encargada de construir una respuesta estándar para una API Gateway.
 *
 * Este servicio toma un objeto de respuesta genérico y lo envuelve en una estructura de respuesta
 * que es comprensible para API Gateway, incluyendo un mensaje de estado y un código de respuesta.
 */
public class BuildResponseUtil {

    /**
     * Construye una respuesta exitosa con un objeto de respuesta.
     *
     * @param response El objeto que contiene la respuesta de la API, que será convertido a una cadena.
     * @return Un objeto {@link APIGatewayProxyResponseEvent} que contiene el código de estado y el cuerpo.
     */
    public static final APIGatewayProxyResponseEvent buildSucces(Object response) {
        // Crear el objeto ResponseDto que encapsula la respuesta de la API
        ResponseDto responseDto = new ResponseDto();

        // Asignar valores al ResponseDto
        responseDto.setMessage(ConstantsEnum.VAR_MESSAGE.getValue()); // Mensaje estándar de la respuesta
        responseDto.setStatus(ConstantsEnum.VAR_STATUS_CODE.getValue()); // Código de estado estándar (200)

        // Convertir la respuesta en formato JSON para ser incluida en el cuerpo de la respuesta
        responseDto.setResponse(Util.object2String(response));

        // Crear y retornar la respuesta para API Gateway con el cuerpo y el código de estado
        return new APIGatewayProxyResponseEvent()
                .withBody(Util.object2String(responseDto))  // El cuerpo contiene el ResponseDto en formato JSON
                .withStatusCode(Integer.valueOf(ConstantsEnum.VAR_STATUS_CODE.getValue())); // Establecer código de estado (200)
    }
}
