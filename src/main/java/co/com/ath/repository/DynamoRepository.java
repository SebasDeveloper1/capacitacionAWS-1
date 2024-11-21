package co.com.ath.repository;

import co.com.ath.model.ParameterStore;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

/**
 * Repositorio encargado de construir y configurar instancias necesarias para interactuar con DynamoDB.
 *
 * Proporciona métodos estáticos para configurar un cliente de DynamoDB y un mapeador (DynamoDBMapper)
 * basados en los parámetros recibidos desde un objeto {@link ParameterStore}.
 */
public class DynamoRepository {

    /**
     * Nombre de la tabla en DynamoDB.
     */
    static String tableName;

    /**
     * Endpoint de conexión con DynamoDB.
     */
    static String endpoint;

    /**
     * Región donde se encuentra configurado DynamoDB.
     */
    static String region;

    /**
     * Construye y devuelve una instancia de {@link DynamoDBMapper}, configurada con los parámetros
     * proporcionados a través del objeto {@link ParameterStore}.
     *
     * @param parameterStore Objeto que contiene los parámetros necesarios para la configuración,
     *                       como el nombre de la tabla, el endpoint y la región.
     * @return Instancia configurada de {@link DynamoDBMapper}.
     */
    public static DynamoDBMapper build(ParameterStore parameterStore) {
        // Asignar parámetros desde el objeto ParameterStore
        tableName = parameterStore.getTableName();
        endpoint = parameterStore.getEndpointDynamo();
        region = parameterStore.getRegion();

        // Configuración del mapeador DynamoDB, incluyendo reemplazo de nombre de tabla
        DynamoDBMapperConfig mapperConfig = new DynamoDBMapperConfig.Builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(tableName))
                .build();

        // Construcción del cliente DynamoDB
        AmazonDynamoDB client = buildClient();

        // Retornar el mapeador configurado
        return new DynamoDBMapper(client, mapperConfig);
    }

    /**
     * Construye y devuelve un cliente de DynamoDB configurado con el endpoint y región especificados.
     *
     * @return Instancia de {@link AmazonDynamoDB} configurada.
     */
    public static AmazonDynamoDB buildClient() {
        // Crear cliente de DynamoDB con configuración de endpoint y región
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .build();
    }
}
