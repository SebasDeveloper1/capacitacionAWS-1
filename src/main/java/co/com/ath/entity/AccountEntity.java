package co.com.ath.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa una entidad de cuenta almacenada en una tabla DynamoDB.
 *
 * Esta clase está mapeada a la tabla "DYNAMO_SPI_BOCC" en DynamoDB y define
 * los atributos que forman parte de una cuenta bancaria.
 */
@DynamoDBTable(tableName = "DYNAMO_SPI_BOCC")
@Getter
@Setter
public class AccountEntity {

    /**
     * Clave primaria hash de la tabla DynamoDB.
     * Representa el identificador único de la cuenta.
     */
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    /**
     * Clave de ordenamiento de la tabla DynamoDB.
     * Actúa como un identificador secundario para consultas más específicas.
     */
    @DynamoDBRangeKey(attributeName = "sk")
    private String sk;

    /**
     * Atributo que almacena el número de cuenta bancaria.
     */
    @DynamoDBAttribute(attributeName = "accountNumber")
    private String accountNumber;

    /**
     * Atributo que almacena el tipo de cuenta bancaria (por ejemplo, ahorro o corriente).
     */
    @DynamoDBAttribute(attributeName = "accountType")
    private String accountType;

    /**
     * Atributo que almacena una llave única asociada a la cuenta.
     */
    @DynamoDBAttribute(attributeName = "accountKey")
    private String accountKey;

    /**
     * Atributo que almacena el nombre del banco al que pertenece la cuenta.
     */
    @DynamoDBAttribute(attributeName = "bank")
    private String bank;

    /**
     * Atributo que almacena el saldo de la cuenta bancaria.
     */
    @DynamoDBAttribute(attributeName = "balance")
    private Double balance;

    /**
     * Atributo que almacena información sobre el usuario asociado a la cuenta.
     * Representa la relación entre la cuenta bancaria y su propietario.
     */
    @DynamoDBAttribute(attributeName = "user")
    private UserEntity user;
}
