package co.com.ath.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo que representa la información básica de una cuenta bancaria.
 *
 * Esta clase encapsula los datos esenciales de una cuenta bancaria, como el número,
 * tipo, clave asociada, banco y saldo. Se utiliza como parte de la estructura de
 * solicitud (Request) para operaciones relacionadas con cuentas.
 */
@Getter
@Setter
public class AccountInfo {

    /**
     * Número único de la cuenta bancaria.
     */
    private String accountNumber;

    /**
     * Tipo de la cuenta bancaria (por ejemplo, ahorro, corriente).
     */
    private String accountType;

    /**
     * Llave única asociada a la cuenta, utilizada para identificación interna.
     */
    private String accountKey;

    /**
     * Nombre del banco al que pertenece la cuenta.
     */
    private String bank;

    /**
     * Saldo actual de la cuenta bancaria.
     */
    private Double balance;
}
