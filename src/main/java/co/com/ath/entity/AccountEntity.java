package co.com.ath.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

@DynamoDBTable(tableName = "DYNAMO_SPI_BOCC")
@Getter
@Setter
public class AccountEntity {

    @DynamoDBHashKey(attributeName = "id")
    private String id;
    @DynamoDBRangeKey(attributeName = "sk")
    private String sk;
    @DynamoDBAttribute(attributeName = "accountNumber")
    private String accountNumber;
    @DynamoDBAttribute(attributeName = "accountType")
    private String accountType;
    @DynamoDBAttribute(attributeName = "user")
    private UserEntity user;

}
