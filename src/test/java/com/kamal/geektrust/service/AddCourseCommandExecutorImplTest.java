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

import static org.junit.jupiter.api.Assertions.*;

public class AddCourseCommandExecutorImplTest {

    Command cmd1;
    CommandExecutor exe1;
    private  TreeMap<String , Course> courses;
    private  Map<String,Course> registrationIdWithCourse;
    private final ByteArrayOutputStream printStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(printStream));
        cmd1 = CommandServiceImpl.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        exe1 = CommandExecutionFactory.getExecutor(cmd1);

        courses = new TreeMap<>();
        registrationIdWithCourse = new HashMap<>();
    }

    @Test
    public void testExecute() throws InvalidInputException, CourseFullException {
        assertDoesNotThrow( ()->exe1.execute(courses , registrationIdWithCourse , cmd1));

    }
    @Test
    public void testSuccessMessage() throws InvalidInputException, CourseFullException {
        exe1.execute(courses , registrationIdWithCourse , cmd1);
        assertEquals("OFFERING-JAVA-JAMES",printStream.toString().trim());
    }
}
