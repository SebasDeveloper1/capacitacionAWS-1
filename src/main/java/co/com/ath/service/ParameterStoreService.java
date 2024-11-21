package co.com.ath.service;

import co.com.ath.constants.ConstantsEnum;
import co.com.ath.model.ParameterStore;
import co.com.ath.util.ParameterStoreUtil;
import co.com.ath.util.Util;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Servicio encargado de obtener los parámetros de configuración desde el Parameter Store.
 *
 * Esta clase interactúa con el {@link ParameterStoreUtil} para recuperar los parámetros necesarios
 * (como el nombre de la tabla, la región y el endpoint de DynamoDB) desde el Parameter Store y luego
 * los asigna a un objeto {@link ParameterStore}.
 */
@Slf4j
public class ParameterStoreService {

    /**
     * Obtiene los parámetros de configuración desde el Parameter Store y los mapea a un objeto
     * {@link ParameterStore}.
     *
     * Este método realiza lo siguiente:
     * 1. Recupera los parámetros necesarios desde el Parameter Store utilizando la utilidad {@link ParameterStoreUtil}.
     * 2. Asigna los valores recuperados a un objeto {@link ParameterStore}.
     * 3. Devuelve el objeto {@link ParameterStore} con los parámetros configurados.
     *
     * @return Un objeto {@link ParameterStore} con los parámetros de configuración.
     */
    public ParameterStore getParameter() {
        // Crear una nueva instancia de ParameterStore para almacenar los parámetros
        ParameterStore parameterStore = new ParameterStore();

        // Obtener los parámetros del Parameter Store utilizando la utilidad
        log.info("Iniciando la recuperación de parámetros del Parameter Store.");
        Map<String, String> mapaParametros = ParameterStoreUtil.getParameters(ConstantsEnum.VAR_PATH_PARAMETER_STORE.getValue());

        // Asignar los valores de los parámetros a la instancia de ParameterStore
        parameterStore.setRegion(mapaParametros.get(ConstantsEnum.VAR_PAR_NAME_REGION.getValue()));
        parameterStore.setTableName(mapaParametros.get(ConstantsEnum.VAR_PAR_TABLE_NAME.getValue()));
        parameterStore.setEndpointDynamo(mapaParametros.get(ConstantsEnum.VAR_PAR_DYNAMO_ENDPOINT.getValue()));

        // Log de los parámetros recuperados en formato de cadena para facilitar la trazabilidad
        log.info("Parámetros obtenidos del Parameter Store: {}", Util.object2String(parameterStore));

        // Retornar el objeto ParameterStore con los parámetros configurados
        return parameterStore;
    }
}
