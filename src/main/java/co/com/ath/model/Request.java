package co.com.ath.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo que representa una solicitud de entrada en la aplicación.
 * <p>
 * Esta clase encapsula la información personal de un usuario, así como los datos
 * relacionados con su cuenta bancaria.
 */
@Getter
@Setter
public class Request {

    /**
     * Nombre del usuario asociado a la solicitud.
     */
    private String name;

    /**
     * Apellido del usuario asociado a la solicitud.
     */
    private String lastName;

    /**
     * Tipo de documento de identidad del usuario (por ejemplo, CC, TI, etc.).
     */
    private String documentType;

    /**
     * Número de documento de identidad del usuario.
     */
    private String documentNumber;

    /**
     * Correo electrónico del usuario.
     */
    private String email;

    /**
     * Número de teléfono del usuario.
     */
    private String phone;

    /**
     * Información de la cuenta bancaria asociada al usuario.
     */
    private AccountInfo accountInfo;
}
