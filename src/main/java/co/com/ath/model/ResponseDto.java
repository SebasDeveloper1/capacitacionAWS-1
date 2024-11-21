package co.com.ath.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private String status;
    private String message;
    private String response;
}
