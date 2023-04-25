package com.kamal.coursescheduling;

import com.kamal.coursescheduling.configure.AppConfig;

import java.io.FileNotFoundException;
import java.io.IOException;


public class CourseSchedulingApp {
    public static void main(String[] args) {
        try {
            int  length = 1;

            // checking file  is given or not
            if (args.length == length) {
                String arguments = args[0];

                //sending  file  to processing
                AppConfig.configure(arguments);
            }
            else throw new FileNotFoundException("Input file is not supplied");
        } catch (Exception ex) {System.out.println(ex.getMessage());}

    }
}
