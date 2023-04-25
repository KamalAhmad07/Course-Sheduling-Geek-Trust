package com.kamal.coursescheduling.service.ServiceImpl;

import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.entity.Employee;
import com.kamal.coursescheduling.exception.InvalidInputException;

import java.util.Map;

public interface RegisterCourseCommand {
     Employee createEmployeeObject(Command command) throws InvalidInputException;
     void addEmployeeToCourse(Employee employee, Course course, Map<String, Course> registrationIdCourseMap);
}
