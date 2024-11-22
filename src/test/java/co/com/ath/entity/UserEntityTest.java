package co.com.ath.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase UserEntity
 */

class UserEntityTest {

    /**
     * Prueba unitaria para verificar que se pueden obtener y configurar
     * los valores de los atributos de la entidad UserEntity.
     */
    @Test
    void testGettersAndSetters() {
        // Crear una instancia de la entidad
        UserEntity user = new UserEntity();

        // Configurar valores para los atributos
        user.setName("Ronald");
        user.setLastName("Luna");
        user.setDocumentType("CC");
        user.setDocumentNumber("1234567890");
        user.setEmail("ronaldluna@mail.com");
        user.setPhone("1234567890");

        // Verificar que se pueden obtener los valores configurados
        assertEquals("Ronald", user.getName());
        assertEquals("Luna", user.getLastName());
        assertEquals("CC", user.getDocumentType());
        assertEquals("1234567890", user.getDocumentNumber());
        assertEquals("ronaldluna@mail.com", user.getEmail());
        assertEquals("1234567890", user.getPhone());
    }

    /**
     * Prueba unitaria para verificar que los valores iniciales de los atributos
     * de la entidad UserEntity son nulos.
     */
    @Test
    void testDefaultValues() {
        // Crear una instancia de la entidad sin configurar valores
        UserEntity user = new UserEntity();

        // Verificar que los valores iniciales sean nulos
        assertNull(user.getName());
        assertNull(user.getLastName());
        assertNull(user.getDocumentType());
        assertNull(user.getDocumentNumber());
        assertNull(user.getEmail());
        assertNull(user.getPhone());
    }

}