package com.project.sns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

// TODO : implement
@Getter
@AllArgsConstructor
public class SnsApplicationException extends RuntimeException{

    private ErrorCode errorCode;
    private String message;

    public SnsApplicationException(ErrorCode errorCode) { //메시지가 없는 경우도 있을 수 있으니까
         this.errorCode = errorCode;
         this.message = null;
    }
    @Override
    public String getMessage() {

        if (message == null) {
            return errorCode.getMessage();
        }
        return String.format("%s. %s", errorCode.getMessage(), message);
    }

}
