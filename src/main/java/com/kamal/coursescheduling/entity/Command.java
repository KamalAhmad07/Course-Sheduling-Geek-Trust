package com.kamal.coursescheduling.entity;

import java.util.List;

import com.kamal.coursescheduling.enums.CommandOperator;

public class Command {
    private final CommandOperator command;
    private final List<String> listData;

    public Command(CommandOperator command, List<String> listData){
        this.command = command;
        this.listData = listData;
    }

    public CommandOperator getCommand() {
        return command;
    }

    public List<String> getListData() {
        return listData;
    }

}
