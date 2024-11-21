package co.com.ath.constants;

/**
 * Enumeración que contiene constantes utilizadas en el proyecto.
 *
 * Esta enumeración agrupa valores constantes asociados a parámetros y configuraciones
 * para evitar redundancia y errores.
 */
public enum ConstantsEnum {

    // Constantes relacionadas con rutas y parámetros de configuración
    /**
     * Ruta para el almacenamiento de parámetros.
     */
    VAR_PATH_PARAMETER_STORE("/Semillero/capacitacion-semillero/"),

    /**
     * Nombre de la tabla utilizada en la configuración.
     */
    VAR_PAR_TABLE_NAME("/Semillero/capacitacion-semillero/nombreTabla"),

    /**
     * Nombre de la región configurada.
     */
    VAR_PAR_NAME_REGION("/Semillero/capacitacion-semillero/region"),

    /**
     * Endpoint de conexión a DynamoDB.
     */
    VAR_PAR_DYNAMO_ENDPOINT("/Semillero/capacitacion-semillero/dynamoEndpoint"),

    // Constantes relacionadas con mensajes y códigos de estado
    /**
     * Mensaje predeterminado para solicitudes recibidas.
     */
    VAR_MESSAGE("SOLICITUD RECIBIDA"),

    /**
     * Código de estado HTTP predeterminado.
     */
    VAR_STATUS_CODE("200");

    // Variable para almacenar el valor asociado a cada constante
    private String value;

    /**
     * Constructor de la enumeración.
     *
     * @param value Valor asociado a la constante.
     */
    ConstantsEnum(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor asociado a la constante.
     *
     * @return Valor de la constante.
     */
    public String getValue() {
        return value;
    }
}
