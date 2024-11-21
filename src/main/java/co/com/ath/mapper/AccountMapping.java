package co.com.ath.mapper;

import co.com.ath.entity.AccountEntity;
import co.com.ath.entity.UserEntity;
import co.com.ath.model.Request;

public class AccountMapping {
    public AccountEntity accountEntityMapping(Request request) {
        AccountEntity entity = new AccountEntity();
        entity.setId(request.getDocumentNumber());
        entity.setSk(request.getAccountInfo().getAccountNumber());
        entity.setAccountNumber(request.getAccountInfo().getAccountNumber());
        entity.setAccountType(request.getAccountInfo().getAccountType());
        entity.setAccountKey(request.getAccountInfo().getAccountKey());
        entity.setBank(request.getAccountInfo().getBank());

        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setDocumentType(request.getDocumentType());
        user.setDocumentNumber(request.getDocumentNumber());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        entity.setUser(user);

        return entity;
    }
}
