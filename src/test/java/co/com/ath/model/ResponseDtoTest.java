package co.com.ath.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResponseDtoTest {

    private ResponseDto responseDto;

    @BeforeEach
    public void setUp() {
        responseDto = new ResponseDto();
    }

    @Test
    public void testGettersAndSetters() {
        // Asignación de valores
        responseDto.setStatus("Success");
        responseDto.setMessage("Operation completed successfully");
        responseDto.setResponse("Data processed");

        // Verificación de los getters
        assertEquals("Success", responseDto.getStatus());
        assertEquals("Operation completed successfully", responseDto.getMessage());
        assertEquals("Data processed", responseDto.getResponse());
    }

    @Test
    public void testDefaultConstructor() {
        // Comprobamos que los valores por defecto sean null
        assertNull(responseDto.getStatus());
        assertNull(responseDto.getMessage());
        assertNull(responseDto.getResponse());
    }

    @Test
    public void testStatusSetterAndGetter() {
        // Probar el setter y getter del status
        responseDto.setStatus("Failure");
        assertEquals("Failure", responseDto.getStatus());
    }

    @Test
    public void testMessageSetterAndGetter() {
        // Probar el setter y getter del message
        responseDto.setMessage("An error occurred");
        assertEquals("An error occurred", responseDto.getMessage());
    }

    @Test
    public void testResponseSetterAndGetter() {
        // Probar el setter y getter del response
        responseDto.setResponse("Error data");
        assertEquals("Error data", responseDto.getResponse());
    }
}