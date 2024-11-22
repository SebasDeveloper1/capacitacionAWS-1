package co.com.ath.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de pruebas unitarias para la clase ConstantsEnum.
 */
public class ConstantsEnumTest {

    /**
     * Prueba para verificar que el valor asociado a la constante VAR_PATH_PARAMETER_STORE es correcto.
     */
    @Test
    public void testVarPathParameterStore() {
        assertEquals("/Semillero/capacitacion-semillero/", ConstantsEnum.VAR_PATH_PARAMETER_STORE.getValue(),
                "El valor de VAR_PATH_PARAMETER_STORE debería ser '/Semillero/capacitacion-semillero/'");
    }

    /**
     * Prueba para verificar que el valor asociado a la constante VAR_PAR_TABLE_NAME es correcto.
     */
    @Test
    public void testVarParTableName() {
        assertEquals("/Semillero/capacitacion-semillero/nombreTabla", ConstantsEnum.VAR_PAR_TABLE_NAME.getValue(),
                "El valor de VAR_PAR_TABLE_NAME debería ser '/Semillero/capacitacion-semillero/nombreTabla'");
    }

    /**
     * Prueba para verificar que el valor asociado a la constante VAR_PAR_NAME_REGION es correcto.
     */
    @Test
    public void testVarParNameRegion() {
        assertEquals("/Semillero/capacitacion-semillero/region", ConstantsEnum.VAR_PAR_NAME_REGION.getValue(),
                "El valor de VAR_PAR_NAME_REGION debería ser '/Semillero/capacitacion-semillero/region'");
    }

    /**
     * Prueba para verificar que el valor asociado a la constante VAR_PAR_DYNAMO_ENDPOINT es correcto.
     */
    @Test
    public void testVarParDynamoEndpoint() {
        assertEquals("/Semillero/capacitacion-semillero/dynamoEndpoint", ConstantsEnum.VAR_PAR_DYNAMO_ENDPOINT.getValue(),
                "El valor de VAR_PAR_DYNAMO_ENDPOINT debería ser '/Semillero/capacitacion-semillero/dynamoEndpoint'");
    }

    /**
     * Prueba para verificar que el valor asociado a la constante VAR_MESSAGE es correcto.
     */
    @Test
    public void testVarMessage() {
        assertEquals("SOLICITUD RECIBIDA", ConstantsEnum.VAR_MESSAGE.getValue(),
                "El valor de VAR_MESSAGE debería ser 'SOLICITUD RECIBIDA'");
    }

    /**
     * Prueba para verificar que el valor asociado a la constante VAR_STATUS_CODE es correcto.
     */
    @Test
    public void testVarStatusCode() {
        assertEquals("200", ConstantsEnum.VAR_STATUS_CODE.getValue(),
                "El valor de VAR_STATUS_CODE debería ser '200'");
    }
}
