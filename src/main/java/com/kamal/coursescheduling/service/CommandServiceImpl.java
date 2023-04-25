package com.kamal.coursescheduling.service;

import com.kamal.coursescheduling.enums.CommandOperator;
import com.kamal.coursescheduling.constant.Constant;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandServiceImpl implements  CommandService {
    
	public static CommandServiceImpl commandServiceImplProvider = null;

    public static CommandServiceImpl getInstance(){

        if(commandServiceImplProvider == null){
        	commandServiceImplProvider = new CommandServiceImpl();
        }
        return commandServiceImplProvider;
    }

    @Override
    public Command getCommandFromString(String input) throws InvalidInputException {
        try {
            String[] dataArr = input.split(" ");
            CommandOperator enumOperator = CommandOperator.valueOf(Constant.getValue(dataArr[0]));

             int skip = 1;
            List<String> dataList =
                    Arrays.stream(dataArr).skip(skip).collect(Collectors.toList());
            Command command = new Command(enumOperator, dataList);
            this.validateInputCommand(enumOperator,command);
            return command;
        } catch (Exception e) {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    @Override
    public   void validateInputCommand(CommandOperator input , Command command) throws InvalidInputException {
        int  size = command.getListData().size();
        if(input.getArgumentsNumber()!=size){
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }
}
