package com.kamal.coursescheduling.entity;

import java.util.*;

public class Course implements Comparable<Course> {
    private final String id;
    private final String name;
    private final String instructor;
    private final Date date;
    private final int minCapacity;
    private final int maxCapacity;
    private boolean isAllot;
    private boolean isCancel;

    private final Map<String , Employee> addEmployees;


    public Course(String id, String name, String instructor, Date date, int minCapacity, int maxCapacity, boolean isAllotted,boolean isCancelled) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.date = date;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.isAllot = isAllotted;
        this.isCancel= isCancelled;
        addEmployees = new TreeMap<>();
    }

    public String getCourseID() {
        return id;
    }

    public String getCourseName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public Date getDate() {
        return date;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isAllotted() {
        return isAllot;
    }

    public boolean isCancelled() {
        return isCancel;
    }

    public void setAllotted(boolean isAllot) {
    	this.isAllot = isAllot;
    }

    public void setCancelled(boolean isCancel) {
        this.isCancel = isCancel;
    }

    public Map<String, Employee> getAddedEmployees() {
        return addEmployees;
    }

    public String addEmployee(Employee e){
        String registrationID = "REG-COURSE-"+e.getName()+"-"+this.name;
        this.addEmployees.put(registrationID , e);
        return registrationID;
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }
}
