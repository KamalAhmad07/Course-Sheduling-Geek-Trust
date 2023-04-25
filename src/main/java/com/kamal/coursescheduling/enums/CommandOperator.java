package com.kamal.coursescheduling.enums;

public enum CommandOperator {
    ADD_COURSE_OFFERING(5),
    CANCEL(1),
    REGISTER(2),
    ALLOT(1);

    CommandOperator(Integer numArgs){
        this.argumentsNumber = numArgs;
    }

    private final Integer argumentsNumber;

    public Integer getArgumentsNumber() {
        return argumentsNumber;
    }
}

