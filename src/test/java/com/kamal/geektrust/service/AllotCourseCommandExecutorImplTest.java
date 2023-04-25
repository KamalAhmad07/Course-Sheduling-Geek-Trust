package com.kamal.geektrust.service;

import com.kamal.coursescheduling.factory.CommandExecutionFactory;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.exception.InvalidInputException;
import com.kamal.coursescheduling.service.CommandExecutor;
import com.kamal.coursescheduling.service.CommandServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class AllotCourseCommandExecutorImplTest {


	Command cmd1;
    CommandExecutor exe;
    private TreeMap<String , Course> courses;
    private Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(outContent));
        cmd1 = CommandServiceImpl.getInstance().getCommandFromString("ALLOT OFFERING-JAVA-JAMES");
        exe = CommandExecutionFactory.getExecutor(cmd1);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }


    @Test
    public void testExecute() {
        assertThrows(InvalidInputException.class , ()->exe.execute(courses , registrationIdCourseMap , cmd1));
    }

}
