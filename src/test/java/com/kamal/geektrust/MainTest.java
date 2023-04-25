package com.kamal.geektrust;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kamal.coursescheduling.CourseSchedulingApp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final ByteArrayOutputStream printStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(printStream));
    }

    @Test
    public void testMain(){
        String[] path = {"sample_input\\input1.txt"};
        CourseSchedulingApp.main(path);
        assertTrue(!printStream.toString().trim().isEmpty());
    }
}
