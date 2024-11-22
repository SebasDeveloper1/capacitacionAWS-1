package co.com.ath.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase AccountEntity.
 */
class AccountEntityTest {
/**
 * Prueba unitaria para verificar la configuración de los getters y setters
 * de la entidad AccountEntity.
 * */
    @Test
    void testGettersAndSetters() {
        // Crear una instancia de la entidad
        AccountEntity account = new AccountEntity();

        // Configurar valores para los atributos
        account.setId("1234567890");
        account.setSk("1111111111");
        account.setAccountNumber("1111111111");
        account.setAccountType("Ahorros");
        account.setAccountKey("122121212");
        account.setBank("ABC");
        account.setBalance(1000.50);

        // Crear y asociar un usuario
        UserEntity user = new UserEntity();
        user.setName("Ronald");
        user.setLastName("Luna");
        user.setDocumentType("CC");
        user.setDocumentNumber("1234567890");
        user.setEmail("ronaldluna@mail.com");
        user.setPhone("1234567890");
        account.setUser(user);

        // Verificar los valores establecidos
        assertEquals("1234567890", account.getId());
        assertEquals("1111111111", account.getSk());
        assertEquals("1111111111", account.getAccountNumber());
        assertEquals("Ahorros", account.getAccountType());
        assertEquals("122121212", account.getAccountKey());
        assertEquals("ABC", account.getBank());
        assertEquals(1000.50, account.getBalance());

        // Verificar la relación con el usuario
        assertNotNull(account.getUser());
        assertEquals("Ronald", account.getUser().getName());
        assertEquals("Luna", account.getUser().getLastName());
        assertEquals("CC", account.getUser().getDocumentType());
        assertEquals("1234567890", account.getUser().getDocumentNumber());
        assertEquals("ronaldluna@mail.com", account.getUser().getEmail());
        assertEquals("1234567890", account.getUser().getPhone());
    }
/**
 * Prueba unitaria para verificar la configuración de los valores por defecto
 * de la entidad AccountEntity.
 * */
    @Test
    void testDefaultValues() {
        // Crear una instancia de la entidad sin configurar valores
        AccountEntity account = new AccountEntity();

        // Verificar que los valores iniciales sean nulos
        assertNull(account.getId());
        assertNull(account.getSk());
        assertNull(account.getAccountNumber());
        assertNull(account.getAccountType());
        assertNull(account.getAccountKey());
        assertNull(account.getBank());
        assertNull(account.getUser());
        assertNull(account.getBalance());
    }
}
