package com.kamal.coursescheduling.service;

import com.kamal.coursescheduling.enums.CommandOperator;
import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.exception.InvalidInputException;

public interface CommandService {

    void validateInputCommand(CommandOperator input, Command command) throws InvalidInputException;
    Command getCommandFromString(String input) throws InvalidInputException;
}
