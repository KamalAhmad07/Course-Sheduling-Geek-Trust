package com.kamal.coursescheduling.entity;

import com.kamal.coursescheduling.constant.Constant;
import com.kamal.coursescheduling.exception.InvalidInputException;


public class Employee {
    private final String name;
    private final String email;


    public Employee(String email) throws InvalidInputException {
        if (Constant.VALID_EMAIL.matcher(email).matches()) {
            this.email = email; this.name = this.email.substring(0, this.email.indexOf('@'));
        }else throw new InvalidInputException("INPUT_DATA_ERROR");
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return email;
    }

}
