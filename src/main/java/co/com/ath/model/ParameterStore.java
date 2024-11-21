package co.com.ath.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterStore {
    private String tableName;
    private String endpointDynamo;
    private String region;
}
