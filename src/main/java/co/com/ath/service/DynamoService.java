package co.com.ath.service;

import co.com.ath.entity.AccountEntity;
import co.com.ath.mapper.AccountMapping;
import co.com.ath.model.ParameterStore;
import co.com.ath.model.Request;
import co.com.ath.repository.DynamoRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * Servicio encargado de interactuar con la base de datos DynamoDB.
 *
 * Este servicio utiliza un mapeador de DynamoDB y un objeto de repositorio para guardar
 * la información de la cuenta proporcionada en un objeto {@link Request}. Se encarga de
 * realizar el mapeo de los datos recibidos y luego guardarlos en DynamoDB.
 */
@Slf4j
public class DynamoService {

    // Instancia del mapeador de cuenta
    private AccountMapping mapping = new AccountMapping();

    // Instancia del mapeador de DynamoDB
    private DynamoDBMapper mapper;

    /**
     * Guarda los datos de la cuenta en DynamoDB.
     *
     * Este método realiza lo siguiente:
     * 1. Establece una conexión a DynamoDB usando los parámetros proporcionados.
     * 2. Mapea los datos de la solicitud {@link Request} a un objeto {@link AccountEntity}.
     * 3. Guarda la entidad mapeada en DynamoDB.
     *
     * @param request Los datos de la cuenta proporcionados por el cliente en la solicitud.
     * @param parameterStore Parámetros de configuración de DynamoDB (nombre de la tabla, endpoint, región).
     */
    public void guardar(Request request, ParameterStore parameterStore) {
        // Ingreso al proceso de guardar datos en DynamoDB
        log.info("Iniciando proceso para guardar la cuenta en DynamoDB.");

        // Establecer la conexión con DynamoDB utilizando los parámetros proporcionados
        mapper = DynamoRepository.build(parameterStore);

        // Mapeo de la información recibida para almacenar en la base de datos
        log.info("Iniciando mapeo de la información de la solicitud.");
        AccountEntity entity = mapping.accountEntityMapping(request);

        // Log para verificar el mapeo correcto
        log.debug("Entidad mapeada: {}", entity);

        // Guardar la entidad mapeada en DynamoDB
        log.info("Guardando la entidad en DynamoDB...");
        mapper.save(entity);

        // Confirmación de la operación exitosa
        log.info("La cuenta ha sido guardada exitosamente en DynamoDB.");
    }
}
