package com.kamal.coursescheduling.factory;

import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.service.CommandExecutor;
import com.kamal.coursescheduling.service.ServiceImpl.AddCourseCommandImpl;
import com.kamal.coursescheduling.service.ServiceImpl.AllotCourseCommandImpl;
import com.kamal.coursescheduling.service.ServiceImpl.CancelCourseCommandImpl;
import com.kamal.coursescheduling.service.ServiceImpl.RegisterCourseCommandImpl;

public class CommandExecutionFactory {
    public static CommandExecutor getExecutor(Command cm) {
        CommandExecutor executor = null;
        Command checkCommand  = null;
        if(cm != null){
            switch(cm.getCommand()){
                case ADD_COURSE_OFFERING:
                    executor = new AddCourseCommandImpl();
                    break;
                case CANCEL:
                    executor = new CancelCourseCommandImpl();
                    break;
                case ALLOT:
                    executor = new AllotCourseCommandImpl();
                    break;
                case REGISTER:
                    executor = new RegisterCourseCommandImpl();
                    break;
                default:
                    break;
            }
        }
        return executor;
    }
}
