package co.com.ath.service;

import co.com.ath.entity.AccountEntity;
import co.com.ath.mapper.AccountMapping;
import co.com.ath.model.ParameterStore;
import co.com.ath.model.Request;
import co.com.ath.repository.DynamoRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamoService {
    AccountMapping mapping = new AccountMapping();
    private DynamoDBMapper mapper;

    public void guardar(Request request, ParameterStore parameterStore) {
        log.info("Ingresa a guardar dynamo");
        // Conexion a Dynamo
        mapper = DynamoRepository.build(parameterStore);
        // Mapeo de la informacion que vamos a guardar
        AccountEntity entity = new AccountEntity();
        log.info("Mapeo de la informacion que vamos a guardar");
        entity = mapping.accountEntityMapping(request);

        // Metodo que guarda en Dynamo
        mapper.save(entity);
    }
}
