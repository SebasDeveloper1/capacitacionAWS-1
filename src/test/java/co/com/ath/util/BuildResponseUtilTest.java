package co.com.ath.util;

import co.com.ath.constants.ConstantsEnum;
import co.com.ath.model.ResponseDto;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.junit.jupiter.api.*;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuildResponseUtilTest {

    private static MockedStatic<Util> utilMockedStatic; // Declarar el mock estático a nivel de clase

    @BeforeAll
    static void setUpAll() {
        // Registrar el mock estático una sola vez antes de todos los tests
        utilMockedStatic = Mockito.mockStatic(Util.class);
    }

    @AfterAll
    static void tearDownAll() {
        // Liberar el mock estático después de que todos los tests hayan corrido
        utilMockedStatic.close();
    }

    @Test
    void testBuildSuccess() {
        // Mock de ConstantsEnum y Util.object2String
        String mockResponseJson = "{\"key\":\"value\"}";
        String mockResponseDtoJson = "{\"message\":\"Success\",\"status\":\"200\",\"response\":\"" + mockResponseJson + "\"}";

        utilMockedStatic.when(() -> Util.object2String(any())).thenReturn(mockResponseJson, mockResponseDtoJson);

        // Llamar al método que estamos probando
        Object response = new Object(); // Usar un objeto genérico
        APIGatewayProxyResponseEvent result = BuildResponseUtil.buildSucces(response);

        // Validar el resultado
        assertNotNull(result, "La respuesta no debe ser nula");
        assertEquals(200, result.getStatusCode(), "El código de estado debe ser 200");
        assertEquals(mockResponseDtoJson, result.getBody(), "El cuerpo de la respuesta debe coincidir con el JSON esperado");

        // Verificar llamadas al mock
        utilMockedStatic.verify(() -> Util.object2String(response));
        utilMockedStatic.verify(() -> Util.object2String(any(ResponseDto.class)));
    }

    @Test
    void testBuildSuccessWithNullResponse() {
        // Mock de ConstantsEnum y Util.object2String para manejar respuesta nula
        String mockResponseDtoJson = "{\"message\":\"Success\",\"status\":\"200\",\"response\":\"null\"}";

        utilMockedStatic.when(() -> Util.object2String(null)).thenReturn("null");
        utilMockedStatic.when(() -> Util.object2String(any(ResponseDto.class))).thenReturn(mockResponseDtoJson);

        // Llamar al método con un objeto nulo
        APIGatewayProxyResponseEvent result = BuildResponseUtil.buildSucces(null);

        // Validar el resultado
        assertNotNull(result, "La respuesta no debe ser nula");
        assertEquals(200, result.getStatusCode(), "El código de estado debe ser 200");
        assertEquals(mockResponseDtoJson, result.getBody(), "El cuerpo de la respuesta debe manejar correctamente el valor nulo");

        // Verificar llamadas al mock
        utilMockedStatic.verify(() -> Util.object2String(null), times(1)); // Ajustar el número de invocaciones
    }

}
