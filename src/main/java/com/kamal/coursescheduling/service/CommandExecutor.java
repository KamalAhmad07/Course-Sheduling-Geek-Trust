package com.kamal.coursescheduling.service;

import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.exception.CourseFullException;
import com.kamal.coursescheduling.exception.InvalidInputException;

import java.util.Map;
import java.util.TreeMap;

public interface CommandExecutor {
    void execute(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException;

}
