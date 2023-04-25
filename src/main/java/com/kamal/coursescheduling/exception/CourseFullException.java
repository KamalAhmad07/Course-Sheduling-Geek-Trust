package com.kamal.coursescheduling.exception;

@SuppressWarnings("serial")
public class CourseFullException extends Exception{
    public CourseFullException(String msg){
        super(msg);
    }
}
