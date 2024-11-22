package co.com.ath.mapper;

import co.com.ath.entity.AccountEntity;
import co.com.ath.entity.UserEntity;
import co.com.ath.model.AccountInfo;
import co.com.ath.model.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Pruebas unitarias para la clase AccountMapping
 */

class AccountMappingTest {

    /**
     * Prueba unitaria para verificar el mapeo de la entidad de cuenta a partir de un objeto Request.
     * */
    @Test
    void testAccountEntityMapping() {
        // Crear una instancia de AccountMapping
        AccountMapping mapper = new AccountMapping();

        // Crear un objeto Request con datos simulados
        Request request = new Request();
        request.setName("Ronald");
        request.setLastName("Luna");
        request.setDocumentType("CC");
        request.setDocumentNumber("1234567890");
        request.setEmail("ronaldluna@mail.com");
        request.setPhone("1234567890");

        // Crear y asignar información de cuenta
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountNumber("1111111111");
        accountInfo.setAccountType("Ahorros");
        accountInfo.setAccountKey("122121212");
        accountInfo.setBank("ABC");
        accountInfo.setBalance(1000.50);

        request.setAccountInfo(accountInfo);

        // Ejecutar el mapeo
        AccountEntity accountEntity = mapper.accountEntityMapping(request);

        // Verificar que la entidad de la cuenta no sea nula
        assertNotNull(accountEntity);

        // Verificar que los valores mapeados sean correctos
        assertEquals("1234567890", accountEntity.getId());
        assertEquals("1111111111", accountEntity.getSk());
        assertEquals("1111111111", accountEntity.getAccountNumber());
        assertEquals("Ahorros", accountEntity.getAccountType());
        assertEquals("122121212", accountEntity.getAccountKey());
        assertEquals("ABC", accountEntity.getBank());
        assertEquals(1000.50, accountEntity.getBalance());

        // Verificar los datos del usuario asociado
        UserEntity user = accountEntity.getUser();
        assertNotNull(user);
        assertEquals("Ronald", user.getName());
        assertEquals("Luna", user.getLastName());
        assertEquals("CC", user.getDocumentType());
        assertEquals("1234567890", user.getDocumentNumber());
        assertEquals("ronaldluna@mail.com", user.getEmail());
        assertEquals("1234567890", user.getPhone());
    }
}
