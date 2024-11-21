package co.com.ath.util;

import co.com.ath.constants.ConstantsEnum;
import co.com.ath.model.ResponseDto;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class BuildResponseUtil {
    public static final APIGatewayProxyResponseEvent buildSucces(Object response) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(ConstantsEnum.VAR_MESSAGE.getValue());
        responseDto.setStatus(ConstantsEnum.VAR_STATUS_CODE.getValue());
        responseDto.setResponse(Util.object2String(response));

        return new APIGatewayProxyResponseEvent()
                .withBody(Util.object2String(responseDto)).withStatusCode(Integer.valueOf(ConstantsEnum.VAR_STATUS_CODE.getValue()));
    }
}
