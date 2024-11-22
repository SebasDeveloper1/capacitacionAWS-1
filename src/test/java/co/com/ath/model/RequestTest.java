package co.com.ath.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RequestTest {

    private Request request;
    private AccountInfo accountInfo;

    @BeforeEach
    void setUp() {
        // Inicialización antes de cada prueba
        request = new Request();
        accountInfo = new AccountInfo();

        // Suponemos que AccountInfo tiene algunos campos, por ejemplo:
        // accountInfo.setAccountNumber("123456789");
        // accountInfo.setBankName("Banco XYZ");
    }

    @Test
    void testGettersAndSetters() {
        // Establecer valores usando setters
        request.setName("Ronald");
        request.setLastName("Luna");
        request.setDocumentType("CC");
        request.setDocumentNumber("123456789");
        request.setEmail("ronaldluna@mail.com");
        request.setPhone("123456789");
        request.setAccountInfo(accountInfo);

        // Verificar que los valores se obtienen correctamente usando getters
        assertEquals("Ronald", request.getName());
        assertEquals("Luna", request.getLastName());
        assertEquals("CC", request.getDocumentType());
        assertEquals("123456789", request.getDocumentNumber());
        assertEquals("ronaldluna@mail.com", request.getEmail());
        assertEquals("123456789", request.getPhone());
        assertNotNull(request.getAccountInfo());  // Verifica que accountInfo no es null
    }

    @Test
    void testNullAccountInfo() {
        // Verificar que cuando no se establece accountInfo, permanece null
        assertNull(request.getAccountInfo());
    }

    @Test
    void testAccountInfoAssignment() {
        // Establecer un objeto AccountInfo
        AccountInfo newAccountInfo = new AccountInfo();
        // Supongamos que tiene un metodo setAccountNumber
        // newAccountInfo.setAccountNumber("987654321");

        request.setAccountInfo(newAccountInfo);

        // Verificar que la referencia de accountInfo se establece correctamente
        assertEquals(newAccountInfo, request.getAccountInfo());
    }

}