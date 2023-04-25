package com.kamal.coursescheduling.service.ServiceImpl;

import com.kamal.coursescheduling.constant.Constant;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.entity.Course;
import com.kamal.coursescheduling.service.CommandExecutor;

import java.util.Map;
import java.util.TreeMap;

public class CancelCourseCommandImpl implements CommandExecutor ,CancelCourseCommand{
    @Override
    public void execute(TreeMap<String, Course> courses, Map<String, Course> registrationIdWithCourse, Command command) {
        String regId = command.getListData().get(0);
        if(isValidRegistrationID(regId,registrationIdWithCourse)){
            if(isCourseNotAllotted(regId,registrationIdWithCourse)) System.out.println(regId+" "+Constant.CANCEL_REJECTED);
            else{
                //Remove the registration for the employee...
                removeAddedEmployee(regId,registrationIdWithCourse);
                System.out.println(regId+" "+Constant.CANCEL_ACCEPTED);            }
        }else System.out.println(regId+" "+Constant.CANCEL_ACCEPTED);

    }

    @Override
    public void removeAddedEmployee(String regId, Map<String, Course> registrationIdWithCourse) {
        Course course = registrationIdWithCourse.get(regId);
        course.getAddedEmployees().remove(regId);
        registrationIdWithCourse.remove(regId);
    }

    @Override
    public boolean isCourseNotAllotted(String regId, Map<String, Course> registrationIdCourseMap) {
        return registrationIdCourseMap.get(regId).isAllotted();
    }

    @Override
    public boolean isValidRegistrationID(String regId, Map<String, Course> registrationIdWithCourse) {
       return  registrationIdWithCourse.get(regId)!=null ?true:false;
    }
}
