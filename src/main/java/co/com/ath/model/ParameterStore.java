package co.com.ath.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo que encapsula los parámetros de configuración necesarios para interactuar con DynamoDB.
 *
 * Esta clase almacena información como el nombre de la tabla, el endpoint del servicio DynamoDB
 * y la región en la que se encuentra configurado el servicio. Es útil para centralizar los
 * valores de configuración y facilitar su gestión dentro del proyecto.
 */
@Getter
@Setter
public class ParameterStore {

    /**
     * Nombre de la tabla en DynamoDB.
     * Representa el nombre de la tabla a la cual se conectará la aplicación para realizar operaciones.
     */
    private String tableName;

    /**
     * Endpoint del servicio DynamoDB.
     * Define la URL o dirección del servicio DynamoDB utilizado por la aplicación.
     */
    private String endpointDynamo;

    /**
     * Región de AWS donde está configurado el servicio DynamoDB.
     * Este atributo identifica la región en la que se encuentra la tabla DynamoDB.
     */
    private String region;
}
