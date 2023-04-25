package com.kamal.geektrust.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kamal.coursescheduling.enums.CommandOperator;

import static junit.framework.Assert.assertEquals;

public class CommandOperatorTest {

    Integer registeredValue;
    Integer courseOfferValue;

    @BeforeEach
    public void setup(){
        registeredValue = 2;
        courseOfferValue = 5;
    }
    @Test
    public void testGetNumberOfArguments() {
        assertEquals(CommandOperator.REGISTER.getArgumentsNumber(),registeredValue);
        assertEquals(CommandOperator.ADD_COURSE_OFFERING.getArgumentsNumber(),courseOfferValue);
    }
}
