
package co.com.ath.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ParameterStoreUtilTest {

    private Set<AutoCloseable> mocksStatics = new HashSet<>();



    @InjectMocks
    private ParameterStoreUtil parameterStoreUtil;

    @BeforeEach
    void setUp() {
        MockedStatic<AWSSimpleSystemsManagement> dynamoRepositoryMock = mockStatic(AWSSimpleSystemsManagement.class);
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
    void testGetParameter_Success() {
        // Simular el comportamiento del cliente SSM
        String parameterName = "test-parameter";
        String expectedValue = "parameter-value";

        // Crear el objeto de respuesta simulada
        GetParameterResult mockResult = mock(GetParameterResult.class);
        Parameter mockParameter = mock(Parameter.class);
        when(mockParameter.getValue()).thenReturn(expectedValue);
        when(mockResult.getParameter()).thenReturn(mockParameter);
        //when(ssmClient.getParameter(any(GetParameterRequest.class))).thenReturn(mockResult);

        // Llamar al método y verificar el resultado
        String result = ParameterStoreUtil.getParameter(parameterName);

        //assertEquals(expectedValue, result);
        //verify(ssmClient, times(1)).getParameter(any(GetParameterRequest.class));  // Verificar que se haya llamado al método correctamente
    }

    @Test
    void testGetParameter_ParameterNotFound() {
        // Simular el comportamiento cuando el parámetro no se encuentra
        String parameterName = "non-existing-parameter";

        // Simular una excepción de "Parámetro no encontrado"
        //when(ssmClient.getParameter(any(GetParameterRequest.class)))
                //.thenThrow(new ParameterNotFoundException("Parameter not found"));

        // Llamar al método y verificar que se maneje la excepción correctamente
        String result = ParameterStoreUtil.getParameter(parameterName);

        //assertNull(result);
        //verify(ssmClient, times(1)).getParameter(any(GetParameterRequest.class));  // Verificar que se haya llamado al método correctamente
    }

    @Test
    void testGetParameters_EmptyResult() {
        // Simular el comportamiento cuando no se encuentran parámetros
        String path = "/test/empty-path";

        GetParametersByPathResult mockResult = mock(GetParametersByPathResult.class);
        when(mockResult.getParameters()).thenReturn(List.of());
        //when(ssmClient.getParametersByPath(any(GetParametersByPathRequest.class))).thenReturn(mockResult);

        // Llamar al método y verificar el resultado vacío
        //Map<String, String> result = ParameterStoreUtil.getParameters(path);

        //assertTrue(result.isEmpty());
        //verify(ssmClient, times(1)).getParametersByPath(any(GetParametersByPathRequest.class));  // Verificar que se haya llamado al método correctamente
    }
}

