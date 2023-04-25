package com.kamal.geektrust.service;

import com.kamal.coursescheduling.factory.CommandExecutionFactory;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.exception.CourseFullException;
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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CancelCourseCommandExecutorImplTest {

    Command cmd1;
    Command cmd2;
    Command cmd3;
    CommandExecutor exe1;
    CommandExecutor exe2;
    CommandExecutor exe3;

    private TreeMap<String , Course> courses;
    private Map<String,Course> registrationIdWithCourse;
    private final ByteArrayOutputStream printStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException, CourseFullException {
        System.setOut(new PrintStream(printStream));
        cmd1 = CommandServiceImpl.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        cmd2 = CommandServiceImpl.getInstance().getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        cmd3 = CommandServiceImpl.getInstance().getCommandFromString("CANCEL REG-COURSE-ANDY-JAVA");
        exe1 = CommandExecutionFactory.getExecutor(cmd1);
        exe2 = CommandExecutionFactory.getExecutor(cmd2);
        exe3 = CommandExecutionFactory.getExecutor(cmd3);
        courses = new TreeMap<>();
        registrationIdWithCourse = new HashMap<>();
        exe1.execute(courses , registrationIdWithCourse , cmd1);
        exe2.execute(courses,registrationIdWithCourse , cmd2);

    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(()->exe3.execute(courses , registrationIdWithCourse , cmd3));
    }


}
