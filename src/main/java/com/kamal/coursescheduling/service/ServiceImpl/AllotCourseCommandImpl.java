package com.kamal.coursescheduling.service.ServiceImpl;

import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.entity.Employee;
import com.kamal.coursescheduling.exception.InvalidInputException;
import com.kamal.coursescheduling.service.CommandExecutor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

public class AllotCourseCommandImpl implements CommandExecutor , AllotCourseCommand{
    @Override
    public void execute(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        String courseId = command.getListData().get(0);
        Course course = courses.get(courseId);
        if(course!= null){
            if(course.getAddedEmployees().size()<course.getMinCapacity()){course.setCancelled(true);printCourseData(course);}else{course.setAllotted(true);printCourseData(course);}
        }else{throw new InvalidInputException("INPUT_DATA_ERROR");}
    }

    public void printCourseData(Course course) {
        String status = course.isCancelled()?"COURSE_CANCELED":"CONFIRMED";
        for(Map.Entry<String,Employee> e: course.getAddedEmployees().entrySet()){
            String pattern = "ddMMyyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            System.out.println(e.getKey()+" "+e.getValue().getEmailAddress()+" "+course.getCourseID()+" "+course.getCourseName()+" "+course.getInstructor()+" "
                   + df.format(course.getDate())+" "+status);
        }
    }
}
