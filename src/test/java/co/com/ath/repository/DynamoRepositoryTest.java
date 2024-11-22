package co.com.ath.repository;

import co.com.ath.model.ParameterStore;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static com.amazonaws.util.ValidationUtils.assertNotNull;
import static org.mockito.Mockito.*;

class DynamoRepositoryTest {

    private Set<AutoCloseable> mocksStatics = new HashSet<>();

    @Mock
    private ParameterStore parameterStore;

    @BeforeEach
    void setUp() {

        MockedStatic<DynamoDBMapper> dynamoRepositoryMock = mockStatic(DynamoDBMapper.class);
        mocksStatics.add(dynamoRepositoryMock);
        MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void closeMock() throws Exception{
        for(AutoCloseable moked : mocksStatics){
            moked.close();
        }
    }

    @Test
    void testBuild() {
        // Configuración de los parámetros mockeados
        String tableName = "myTable";
        String endpoint = "http://localhost:8000";
        String region = "us-west-2";

        when(parameterStore.getTableName()).thenReturn(tableName);
        when(parameterStore.getEndpointDynamo()).thenReturn(endpoint);
        when(parameterStore.getRegion()).thenReturn(region);

        // Llamada al método estático build
        DynamoDBMapper mapper = DynamoRepository.build(parameterStore);

        // Verificaciones
        assertNotNull(mapper, "El DynamoDBMapper no debe ser nulo");
        verify(parameterStore).getTableName();
        verify(parameterStore).getEndpointDynamo();
        verify(parameterStore).getRegion();
    }
}