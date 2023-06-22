package com.cource.management.Exception;

public class DefaultMessageException extends  RuntimeException{

    public DefaultMessageException(){
        super();
    }

    public DefaultMessageException(String message){
        super(message);
    }
}
