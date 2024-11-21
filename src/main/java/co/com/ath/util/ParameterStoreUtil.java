package co.com.ath.util;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.*;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utilidad encargada de interactuar con AWS Systems Manager (SSM) Parameter Store.
 *
 * Esta clase proporciona métodos para recuperar parámetros almacenados en el Parameter Store de AWS,
 * ya sea un solo parámetro por nombre o un conjunto de parámetros bajo un camino específico.
 */
@Log4j2
public class ParameterStoreUtil {

    /**
     * Recupera el valor de un parámetro del AWS Parameter Store.
     *
     * Este método se conecta al AWS Systems Manager (SSM) y obtiene el valor de un parámetro por su nombre.
     * Si el parámetro está cifrado, la opción `withDecryption(true)` asegura que el valor se descifre.
     *
     * @param parameterName El nombre del parámetro que se desea recuperar.
     * @return El valor del parámetro o `null` si ocurre algún error.
     */
    public static String getParameter(String parameterName) {
        try {
            // Crear el cliente de AWS Systems Manager
            AWSSimpleSystemsManagement ssmClient = AWSSimpleSystemsManagementClientBuilder.defaultClient();

            // Crear la solicitud para obtener el parámetro
            GetParameterRequest parameterRequest = new GetParameterRequest()
                    .withName(parameterName)
                    .withWithDecryption(true); // Desencriptar si es necesario

            // Obtener el resultado del parámetro
            GetParameterResult parameterResult = ssmClient.getParameter(parameterRequest);

            // Retornar el valor del parámetro
            return parameterResult.getParameter().getValue();
        } catch (ParameterNotFoundException ex) {
            // Log de error si el parámetro no se encuentra
            log.error("Parámetro no encontrado: " + parameterName, ex);
            return null;
        } catch (Exception ex) {
            // Log para otros errores que puedan ocurrir al intentar recuperar el parámetro
            log.error("Error al obtener el parámetro: " + parameterName, ex);
            return null;
        }
    }

    /**
     * Recupera un conjunto de parámetros del AWS Parameter Store bajo un camino específico.
     *
     * Este método obtiene todos los parámetros almacenados en una ruta (path) específica de Parameter Store.
     * Los parámetros se devuelven en un mapa de clave-valor, donde la clave es el nombre del parámetro y el valor es su contenido.
     *
     * @param path El camino de los parámetros que se desea recuperar.
     * @return Un mapa con los parámetros encontrados, donde la clave es el nombre y el valor es el valor del parámetro.
     */
    public static Map<String, String> getParameters(String path) {
        // Crear el cliente de AWS Systems Manager
        AWSSimpleSystemsManagement ssmClient = AWSSimpleSystemsManagementClientBuilder.defaultClient();

        // Crear la solicitud para obtener parámetros bajo un camino específico
        GetParametersByPathRequest getParametersByPathRequest = new GetParametersByPathRequest();
        getParametersByPathRequest.setPath(path);
        getParametersByPathRequest.setRecursive(true); // Buscar de forma recursiva en todas las subcarpetas

        // Obtener el resultado de los parámetros
        GetParametersByPathResult parametersResult = ssmClient.getParametersByPath(getParametersByPathRequest);

        // Convertir la lista de parámetros en un mapa de clave-valor
        List<Parameter> list = parametersResult.getParameters();
        Map<String, String> values = new HashMap<>();
        for (Parameter param : list) {
            values.put(param.getName(), param.getValue());
        }

        // Log de los parámetros recuperados para propósitos de trazabilidad
        log.info("Parámetros recuperados desde el Path '{}': {}", path, values);

        return values;
    }
}
