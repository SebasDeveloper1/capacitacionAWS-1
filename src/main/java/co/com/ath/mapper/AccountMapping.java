package co.com.ath.mapper;

import co.com.ath.entity.AccountEntity;
import co.com.ath.entity.UserEntity;
import co.com.ath.model.Request;

public class AccountMapping {
    public AccountEntity accountEntityMapping(Request request) {
        AccountEntity entity = new AccountEntity();
        entity.setId(request.getAccountInfo().getAccountNumber());
        entity.setSk(request.getAccountInfo().getAccountNumber());
        entity.setAccountNumber(request.getAccountInfo().getAccountNumber());
        entity.setAccountType(request.getAccountInfo().getAccountType());

        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setDocumentType(request.getDocumentType());
        user.setDocumentNumber(request.getDocumentNumber());

        entity.setUser(user);

        return entity;
    }
}
