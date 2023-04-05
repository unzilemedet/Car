package com.unzile.exception;

import lombok.Getter;

@Getter


public class CarException extends RuntimeException{
    public final  ErrorType errorType;
    public CarException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }


    public CarException(ErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }

}
