package com.kamal.coursescheduling.service;

import com.kamal.coursescheduling.entity.Command;
import com.kamal.coursescheduling.exception.InvalidInputException;

import java.io.*;
import java.util.Objects;

public class FileProcessorService {
    private final File file;
    private final BufferedReader br;

    public FileProcessorService(String path) throws FileNotFoundException {
        file = new File(path);
        br = new BufferedReader(new FileReader(file));
    }

    public Command readData() throws InvalidInputException, IOException {
         String data = br.readLine();
         String s= null;
        if(data == s) return null;
        if(isEmpty(data))  readData();

        try{
//            System.err.println(CommandServiceImpl.getInstance().getCommandFromString(data));
            return CommandServiceImpl.getInstance().getCommandFromString(data);
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage()); return readData(); }
    }

    private boolean isEmpty(String sentence) {

        String  sCheck = null;
        int length=0;

        return sentence==sCheck || sentence.length()==length || sentence.trim().isEmpty() || sentence.trim().startsWith("#");
    }
}
