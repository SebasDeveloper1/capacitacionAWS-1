package co.com.ath.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBDocument
public class UserEntity {
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private String lastName;
    @DynamoDBAttribute
    private String documentType;
    @DynamoDBAttribute
    private String documentNumber;
    @DynamoDBAttribute
    private String email;
    @DynamoDBAttribute
    private String phone;
}
