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

    ParameterStoreService parameterStoreService = new ParameterStoreService();
    ParameterStore parameterStore = parameterStoreService.getParameter();

    StringWriter errors;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        log.info("Parametros: " + Util.object2String(parameterStore));
        try {
            return BuildResponseUtil.buildSucces(redict(input));
        } catch (Exception e) {
            errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            log.error("Error: " + errors);
        }
        return null;
    }

    public Object redict(APIGatewayProxyRequestEvent input) {
        if (input != null) {
            String header = input.getHeaders().get("servicio");
            if (header.equalsIgnoreCase("guardar")) {
                DynamoService service = new DynamoService();
                Request request = (Request) Util.string2Object(input.getBody(), Request.class);
                service.guardar(request, parameterStore);
                log.info("Finalizo");
                return "Se guardo correctamente";
            }

        } else {
            return "El input esta vacio";
        }
        return null;
    }
}
