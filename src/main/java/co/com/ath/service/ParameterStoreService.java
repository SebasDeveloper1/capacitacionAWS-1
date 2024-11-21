package co.com.ath.service;

import co.com.ath.constants.ConstantsEnum;
import co.com.ath.model.ParameterStore;
import co.com.ath.util.ParameterStoreUtil;
import co.com.ath.util.Util;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ParameterStoreService {

    public ParameterStore getParameter() {
        ParameterStore parameterStore = new ParameterStore();

        Map<String, String> mapaParametros = ParameterStoreUtil.getParameters(ConstantsEnum.VAR_PATH_PARAMETER_STORE.getValue());
        parameterStore.setRegion(mapaParametros.get(ConstantsEnum.VAR_PAR_NAME_REGION.getValue()));
        parameterStore.setTableName(mapaParametros.get(ConstantsEnum.VAR_PAR_TABLE_NAME.getValue()));
        parameterStore.setEndpointDynamo(mapaParametros.get(ConstantsEnum.VAR_PAR_DYNAMO_ENDPOINT.getValue()));

        log.info("Parameter Store: " + Util.object2String(parameterStore));
        return parameterStore;
    }
}
