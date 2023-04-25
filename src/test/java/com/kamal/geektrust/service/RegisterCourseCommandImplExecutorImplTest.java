package com.kamal.geektrust.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kamal.coursescheduling.factory.CommandExecutionFactory;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.exception.InvalidInputException;
import com.kamal.coursescheduling.service.CommandExecutor;
import com.kamal.coursescheduling.service.CommandServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RegisterCourseCommandImplExecutorImplTest {
    Command com1;
    Command com2;
    CommandExecutor exe1;
    CommandExecutor exe2;
    private TreeMap<String , Course> courseList;
    private Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream printStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(printStream));
        com1 = CommandServiceImpl.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        com2 = CommandServiceImpl.getInstance().getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        exe1 = CommandExecutionFactory.getExecutor(com1);
        courseList = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        exe2 = CommandExecutionFactory.getExecutor(com2);
    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(()->exe2.execute(courseList , registrationIdCourseMap , com2));
    }

}
