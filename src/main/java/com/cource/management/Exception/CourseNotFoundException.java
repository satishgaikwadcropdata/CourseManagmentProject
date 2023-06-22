package com.cource.management.Exception;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(){
        super();
    }

    public CourseNotFoundException(String message){
        super(message);
    }
}
