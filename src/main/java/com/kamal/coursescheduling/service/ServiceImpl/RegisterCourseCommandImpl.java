package com.kamal.coursescheduling.service.ServiceImpl;

import com.kamal.coursescheduling.constant.Constant;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.entity.Employee;
import com.kamal.coursescheduling.exception.CourseFullException;
import com.kamal.coursescheduling.exception.InvalidInputException;
import com.kamal.coursescheduling.service.CommandExecutor;

import java.util.Map;
import java.util.TreeMap;

public class RegisterCourseCommandImpl implements CommandExecutor , RegisterCourseCommand{

    @Override
    public void execute(TreeMap<String, Course> courses, Map<String, Course> registrationIdWithCourse, Command command) throws InvalidInputException, CourseFullException {
        String courseID = command.getListData().get(1);
        Employee employee = createEmployeeObject(command);
        if(courses.containsKey(courseID)) {
            Course course = courses.get(courseID);
            if (!courses.get(courseID).isAllotted() || courses.get(courseID).isCancelled()) {
                if (course.getAddedEmployees().size() == course.getMaxCapacity()) throw new CourseFullException("COURSE_FULL_ERROR");
                 else //register the employee to course......
                    addEmployeeToCourse(employee, course, registrationIdWithCourse);

            } else
                //In case of course is allotted already
                System.out.println("REG-COURSE-" + employee.getName() + "-" + courses.get(courseID).getCourseName() + " " + Constant.REJECTED);

        }else//In case of course ID is not present in the course offering list.
               System.out.println("INPUT_DATA_ERROR");


    }

    @Override
    public void addEmployeeToCourse(Employee employee, Course course, Map<String, Course> registrationIdCourseMap) {
        String regID = course.addEmployee(employee);
        registrationIdCourseMap.put(regID , course);
        System.out.println(regID+" "+Constant.ACCEPTED);
    }

    @Override
    public Employee createEmployeeObject(Command command) throws InvalidInputException {
        return new Employee(command.getListData().get(0));
    }
}
