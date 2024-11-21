package co.com.ath.constants;

public enum ConstantsEnum {
    VAR_PATH_PARAMETER_STORE("/Semillero/capacitacion-semillero/"),
    VAR_PAR_TABLE_NAME("/Semillero/capacitacion-semillero/nombreTabla"),
    VAR_PAR_NAME_REGION("/Semillero/capacitacion-semillero/region"),
    VAR_PAR_DYNAMO_ENDPOINT("/Semillero/capacitacion-semillero/dynamoEndpoint"),

    VAR_MESSAGE("SOLICITUD RECIBIDA"),
    VAR_STATUS_CODE("200");

    private String value;

    ConstantsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
