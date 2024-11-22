package co.com.ath.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterStoreTest {
    @Test
    void testGettersAndSetters() {
        // Instanciar un objeto de la clase ParameterStore
        ParameterStore parameterStore = new ParameterStore();

        // Verificar que los valores por defecto son nulos
        assertNull(parameterStore.getTableName());
        assertNull(parameterStore.getEndpointDynamo());
        assertNull(parameterStore.getRegion());

        // Asignar valores a los campos usando los setters
        parameterStore.setTableName("TestTable");
        parameterStore.setEndpointDynamo("http://localhost:8000");
        parameterStore.setRegion("us-west-2");

        // Verificar que los valores se han asignado correctamente con los getters
        assertEquals("TestTable", parameterStore.getTableName());
        assertEquals("http://localhost:8000", parameterStore.getEndpointDynamo());
        assertEquals("us-west-2", parameterStore.getRegion());
    }

    @Test
    void testEmptyValues() {
        // Verificar comportamiento cuando los valores están vacíos
        ParameterStore parameterStore = new ParameterStore();

        parameterStore.setTableName("");
        parameterStore.setEndpointDynamo("");
        parameterStore.setRegion("");

        assertEquals("", parameterStore.getTableName());
        assertEquals("", parameterStore.getEndpointDynamo());
        assertEquals("", parameterStore.getRegion());
    }

    @Test
    void testNullValues() {
        // Verificar que los valores nulos se manejan correctamente
        ParameterStore parameterStore = new ParameterStore();

        parameterStore.setTableName(null);
        parameterStore.setEndpointDynamo(null);
        parameterStore.setRegion(null);

        assertNull(parameterStore.getTableName());
        assertNull(parameterStore.getEndpointDynamo());
        assertNull(parameterStore.getRegion());
    }
}