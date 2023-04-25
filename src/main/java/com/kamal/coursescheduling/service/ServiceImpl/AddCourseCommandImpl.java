package com.kamal.coursescheduling.service.ServiceImpl;

import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.exception.InvalidInputException;
import com.kamal.coursescheduling.service.CommandExecutor;

import java.text.SimpleDateFormat;
import java.util.*;


public class AddCourseCommandImpl implements CommandExecutor,AddCourseCommand {

    @Override
    public void execute(TreeMap<String, Course> courses, Map<String, Course> registrationIWithCourseMap, Command command) throws InvalidInputException {
        List<String> params = command.getListData();
        Course course = createCourseObject(params);
        courseOffered(courses , course);
    }

    @Override
    public Course createCourseObject(List<String> dataList) throws InvalidInputException {
        Course course = null;
        try{
            String courseName = dataList.get(0);
            String courseInstructor = dataList.get(1);
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
            Date d = inputFormat.parse(dataList.get(2));
            int minCapacity = Integer.parseInt(dataList.get(3));
            int maxCapacity = Integer.parseInt(dataList.get(4));
            course = new Course("OFFERING-"+courseName+"-"+courseInstructor,courseName , courseInstructor , d ,minCapacity , maxCapacity , false, false);
        }catch (Exception e) {throw new InvalidInputException("INPUT_ERROR");}
        return course;
    }

    @Override
    public void courseOffered(TreeMap<String, Course> courses, Course course){
        courses.put(course.getCourseID(),course);
        System.out.println(course.getCourseID());
    }

}
