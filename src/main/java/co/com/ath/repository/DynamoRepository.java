package co.com.ath.repository;

import co.com.ath.model.ParameterStore;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class DynamoRepository {
    static String tableName;
    static String endpoint;
    static String region;

    public static DynamoDBMapper build(ParameterStore parameterStore) {
        tableName = parameterStore.getTableName();
        endpoint = parameterStore.getEndpointDynamo();
        region = parameterStore.getRegion();

        DynamoDBMapperConfig mapperConfig = new DynamoDBMapperConfig.Builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(tableName))
                .build();

        AmazonDynamoDB client = buildClient();
        return new DynamoDBMapper(client, mapperConfig);
    }

    public static AmazonDynamoDB buildClient() {

        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .build();
    }
}
