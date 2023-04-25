package com.kamal.coursescheduling.service.ServiceImpl;

import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.exception.InvalidInputException;

import java.util.List;
import java.util.TreeMap;

public interface AddCourseCommand {
     Course createCourseObject(List<String> dataList) throws InvalidInputException;
     void courseOffered(TreeMap<String, Course> courses, Course course);
    }
