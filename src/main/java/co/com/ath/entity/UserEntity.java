package co.com.ath.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa un documento embebido para un usuario en DynamoDB.
 *
 * Esta clase se utiliza como un objeto anidado dentro de otras entidades
 * en DynamoDB, como por ejemplo, en `AccountEntity`.
 */
@Getter
@Setter
@DynamoDBDocument
public class UserEntity {

    /**
     * Nombre del usuario.
     */
    @DynamoDBAttribute
    private String name;

    /**
     * Apellido del usuario.
     */
    @DynamoDBAttribute
    private String lastName;

    /**
     * Tipo de documento de identidad del usuario (por ejemplo, CC, TI, etc.).
     */
    @DynamoDBAttribute
    private String documentType;

    /**
     * Número de documento de identidad del usuario.
     */
    @DynamoDBAttribute
    private String documentNumber;

    /**
     * Correo electrónico del usuario.
     */
    @DynamoDBAttribute
    private String email;

    /**
     * Número de teléfono del usuario.
     */
    @DynamoDBAttribute
    private String phone;
}
