package com.kamal.coursescheduling.factory;

import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.exception.CourseFullException;
import com.kamal.coursescheduling.exception.InvalidInputException;
import com.kamal.coursescheduling.service.CommandExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LearningManagementSystem {

    private final String orgName;
    private final TreeMap<String , Course> courses;
    private final Map<String,Course> registrationIdWithCourseMap;

    // creates aa owner name  and map for store courses and registration
    public LearningManagementSystem(String name) {
        this.orgName = name; courses = new TreeMap<>(); registrationIdWithCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command inputCmnd) throws InvalidInputException {
        CommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCmnd);
        try{ commandExecutor.execute(courses,registrationIdWithCourseMap, inputCmnd); }catch(CourseFullException e ){ System.out.println(e.getMessage()); }
    }
}
