package com.kamal.coursescheduling.configure;

import com.kamal.coursescheduling.factory.LearningManagementSystem;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.exception.InvalidInputException;
import com.kamal.coursescheduling.service.FileProcessorService;

import java.io.IOException;

public class AppConfig {
    public static  void configure(String str) throws IOException, InvalidInputException {

        // it's  useless but  according  to  project information it's a  owner name.
            String owner = "Kamal";

                LearningManagementSystem lms = new LearningManagementSystem(owner);
                        FileProcessorService file = new FileProcessorService(str);
                        Command command = file.readData();
                        while (command != null) {
                            lms.fulfillCommand(command);
                            command = file.readData();
                        }
    }
}
