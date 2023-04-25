package com.kamal.geektrust.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kamal.coursescheduling.factory.CommandExecutionFactory;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.exception.InvalidInputException;
import com.kamal.coursescheduling.service.CommandServiceImpl;
import com.kamal.coursescheduling.service.ServiceImpl.AddCourseCommandImpl;

public class CommandExecutionFactoryTest {

    Command cmd1 ;
    Command cmd2 ;

    @BeforeEach
    public void setUp() throws InvalidInputException {
        cmd1 = CommandServiceImpl.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        cmd2 = CommandServiceImpl.getInstance().getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
    }

    @Test
    public void getExecutorTest() {
       Assertions.assertTrue(CommandExecutionFactory.getExecutor(cmd1) instanceof AddCourseCommandImpl);
       Assertions.assertFalse(CommandExecutionFactory.getExecutor(cmd2) instanceof AddCourseCommandImpl);
    }



}
