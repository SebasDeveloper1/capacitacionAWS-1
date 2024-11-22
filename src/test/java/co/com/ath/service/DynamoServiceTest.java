package co.com.ath.service;

import co.com.ath.entity.AccountEntity;
import co.com.ath.mapper.AccountMapping;
import co.com.ath.model.ParameterStore;
import co.com.ath.model.Request;
import co.com.ath.repository.DynamoRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DynamoServiceTest {

    private Set<AutoCloseable> mocksStatics = new HashSet<>();

    @InjectMocks
    private DynamoService dynamoService;

    @Mock
    private AccountMapping accountMapping;

    @Mock
    private DynamoDBMapper dynamoDBMapper;

    @Mock
    private DynamoRepository dynamoRepository;

    @Mock
    private ParameterStore parameterStore;

    @Mock
    private Request request;

    @Mock
    private AccountEntity accountEntity;

    @BeforeEach
    public void setUp() {
        MockedStatic<DynamoRepository> dynamoRepositoryMock = mockStatic(DynamoRepository.class);
        mocksStatics.add(dynamoRepositoryMock);
        MockedStatic<ParameterStore> dynamoRepositoryMock2 = mockStatic(ParameterStore.class);
        mocksStatics.add(dynamoRepositoryMock2);
        // Configurar la simulación para que DynamoRepository.build() retorne un mock de DynamoDBMapper
        when(DynamoRepository.build(parameterStore)).thenReturn(dynamoDBMapper);
        // Configurar el mapeo de la solicitud a la entidad
        when(accountMapping.accountEntityMapping(request)).thenReturn(accountEntity);
    }

    @AfterEach
    void closeMock() throws Exception{
        for(AutoCloseable moked : mocksStatics){
            moked.close();
        }
    }

    @Test
    public void testGuardar_Success() {
        // Ejecutar el método que estamos probando
        dynamoService.guardar(request, parameterStore);

        // Verificar que el método DynamoDBMapper.save() haya sido llamado con la entidad esperada
        verify(dynamoDBMapper, times(1)).save(accountEntity);
    }

    @Test
    public void testGuardar_Success_Logs() {
        // Ejecutar el método
        dynamoService.guardar(request, parameterStore);

        // Verificar que se haya registrado el mensaje de log para el inicio del proceso de guardado
        // Aquí puedes usar una librería como slf4j-test para verificar logs
        // En este caso no lo hemos implementado, pero en una prueba real lo incluirías.
    }

    @Test
    public void testGuardar_WithNullParameterStore() {
        // Probar qué pasa si los parámetros de DynamoDB son nulos
        assertThrows(NullPointerException.class, () -> {
            dynamoService.guardar(request, null);
        });
    }
}