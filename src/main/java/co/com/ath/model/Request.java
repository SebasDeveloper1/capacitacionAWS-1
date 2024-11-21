package co.com.ath.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    private String name;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private AccountInfo accountInfo;
}