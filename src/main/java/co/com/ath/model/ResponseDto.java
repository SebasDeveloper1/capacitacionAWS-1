package co.com.ath.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo que representa una respuesta estándar de la aplicación.
 *
 * Esta clase se utiliza para encapsular la información de respuesta
 * que se envía al cliente tras procesar una solicitud. Incluye
 * un estado, un mensaje descriptivo y los datos de la respuesta.
 */
@Getter
@Setter
public class ResponseDto {

    /**
     * Estado de la operación realizada.
     */
    private String status;

    /**
     * Mensaje descriptivo de la operación.
     */
    private String message;

    /**
     * Respuesta en formato de cadena.
     */
    private String response;
}
