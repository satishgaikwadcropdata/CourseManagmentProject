package com.cource.management.Exception;

public class LanguageNotFoundException extends RuntimeException{

    public LanguageNotFoundException(){
        super();
    }
    public LanguageNotFoundException(String message){
        super(message);
    }
}
