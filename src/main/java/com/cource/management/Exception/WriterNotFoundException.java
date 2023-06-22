package com.cource.management.Exception;

public class WriterNotFoundException extends RuntimeException{

    public WriterNotFoundException(){
        super();
    }
    public WriterNotFoundException(String message){
        super(message);
    }
}
