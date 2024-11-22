package co.com.ath.service;

import co.com.ath.constants.ConstantsEnum;
import co.com.ath.model.ParameterStore;
import co.com.ath.repository.DynamoRepository;
import co.com.ath.util.ParameterStoreUtil;
import co.com.ath.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ParameterStoreServiceTest {

    private Set<AutoCloseable> mocksStatics = new HashSet<>();

    @InjectMocks
    private ParameterStoreService parameterStoreService; // Clase a probar

    @Mock
    private ParameterStoreUtil parameterStoreUtil; // Dependencia a simular

    @BeforeEach
    void setUp() {
        MockedStatic<ParameterStoreService> dynamoRepositoryMock = mockStatic(ParameterStoreService.class);
        mocksStatics.add(dynamoRepositoryMock);
        MockedStatic<ParameterStoreUtil> dynamoRepositoryMock2 = mockStatic(ParameterStoreUtil.class);
        mocksStatics.add(dynamoRepositoryMock2);
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @AfterEach
    void closeMock() throws Exception{
        for(AutoCloseable moked : mocksStatics){
            moked.close();
        }
    }

    @Test
    void testGetParameter_EmptyParameters() {
        // Configurar el comportamiento de la dependencia mockeada con parámetros vacíos
        when(parameterStoreUtil.getParameters(anyString())).thenReturn(Map.of());

        // Llamar al método que estamos probando
        ParameterStore result = parameterStoreService.getParameter();

        // Verificar que los parámetros sean null o vacíos (dependiendo de la implementación)
        assertNotNull(result);
        assertNull(result.getRegion());
        assertNull(result.getTableName());
        assertNull(result.getEndpointDynamo());
    }

    @Test
    void testGetParameter_ExceptionHandling() {
        // Simular una excepción en el método getParameters
        when(parameterStoreUtil.getParameters(anyString())).thenThrow(new RuntimeException("Error de conexión"));

        // Verificar que se maneje la excepción adecuadamente
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            parameterStoreService.getParameter();
        });

        assertEquals("Error de conexión", exception.getMessage());
    }
}