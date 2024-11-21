package co.com.ath.util;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.*;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class ParameterStoreUtil {

    public static String getParameter(String parameterName) {
        try {
            AWSSimpleSystemsManagement ssmClient = AWSSimpleSystemsManagementClientBuilder.defaultClient();
            GetParameterRequest parameterRequest = new GetParameterRequest()
                    .withName(parameterName)
                    .withWithDecryption(true);

            GetParameterResult parameterResult = ssmClient.getParameter(parameterRequest);
            return parameterResult.getParameter().getValue();
        } catch (ParameterNotFoundException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    public static Map<String, String> getParameters(String path) {
        AWSSimpleSystemsManagement ssmClient = AWSSimpleSystemsManagementClientBuilder.defaultClient();

        GetParametersByPathRequest getParametersByPathRequest = new GetParametersByPathRequest();
        getParametersByPathRequest.setPath(path);
        getParametersByPathRequest.setRecursive(true);
        GetParametersByPathResult parametersResult = ssmClient.getParametersByPath(getParametersByPathRequest);

        List<Parameter> list = parametersResult.getParameters();
        Map<String, String> values = new HashMap<>();
        for (Parameter param : list) {
            values.put(param.getName(), param.getValue());
        }
        return values;
    }
}
