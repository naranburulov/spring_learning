package com.cydeo.dto;

import org.aspectj.bridge.IMessage;
import org.springframework.http.HttpStatus;

public class ResponseWrapper {          //a template to see as an outcome in API (json)

    private boolean success;
    private String message;
    private Integer code;
    private Object data;        //to cover any dto, which might be needed

    public ResponseWrapper(String message, Object data){
        this.message = message;
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message) {
        this.message= message;
        this.code=HttpStatus.OK.value();
        this.data = data;
    }
}
