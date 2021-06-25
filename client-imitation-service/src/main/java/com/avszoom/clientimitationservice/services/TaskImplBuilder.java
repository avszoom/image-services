package com.avszoom.clientimitationservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TaskImplBuilder {

    @Autowired
    TaskImpl tasks;

    public List<Task> build(Integer noTaskObjects){
        List<Task> taskList = new LinkedList<>();
        for(int i=0;i<noTaskObjects;i++)
            taskList.add(tasks);
        return taskList;
    }
}
