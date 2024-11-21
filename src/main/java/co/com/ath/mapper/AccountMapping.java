package co.com.ath.mapper;

import co.com.ath.entity.AccountEntity;
import co.com.ath.entity.UserEntity;
import co.com.ath.model.Request;

/**
 * Clase encargada de realizar el mapeo entre un objeto de tipo `Request`
 * y una entidad de tipo `AccountEntity`.
 *
 * Esta clase actúa como un mapper, transformando datos de entrada en formato
 * de solicitud (`Request`) en una estructura adecuada para ser persistida
 * en DynamoDB a través de `AccountEntity`.
 */
public class AccountMapping {

    /**
     * Realiza el mapeo de un objeto de tipo `Request` a una instancia de `AccountEntity`.
     *
     * @param request Objeto de entrada que contiene la información de la cuenta
     *                y el usuario asociado.
     * @return Una instancia de `AccountEntity` que contiene los datos mapeados desde el objeto `Request`.
     */
    public AccountEntity accountEntityMapping(Request request) {
        // Crear una instancia de AccountEntity
        AccountEntity entity = new AccountEntity();

        // Mapear datos básicos de la cuenta
        entity.setId(request.getDocumentNumber()); // Usar el número de documento como ID
        entity.setSk(request.getAccountInfo().getAccountNumber()); // Número de cuenta como clave de rango
        entity.setAccountNumber(request.getAccountInfo().getAccountNumber());
        entity.setAccountType(request.getAccountInfo().getAccountType());
        entity.setAccountKey(request.getAccountInfo().getAccountKey());
        entity.setBank(request.getAccountInfo().getBank());
        entity.setBalance(request.getAccountInfo().getBalance());

        // Crear y mapear los datos del usuario asociado
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setDocumentType(request.getDocumentType());
        user.setDocumentNumber(request.getDocumentNumber());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        // Asociar el usuario a la entidad de la cuenta
        entity.setUser(user);

        // Retornar la entidad mapeada
        return entity;
    }
}
