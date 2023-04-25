package com.kamal.coursescheduling.service.ServiceImpl;

import com.kamal.coursescheduling.entity.Course;

import java.util.Map;

public interface CancelCourseCommand {
     void removeAddedEmployee(String regId, Map<String, Course> registrationIdWithCourse);
     boolean isCourseNotAllotted(String regId, Map<String, Course> registrationIdCourseMap);
     boolean isValidRegistrationID(String regId, Map<String, Course> registrationIdWithCourse);
}
