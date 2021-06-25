package com.avszoom.clientimitationservice.controllers;
import com.avszoom.clientimitationservice.executorframework.ExecutionEngine;
import com.avszoom.clientimitationservice.models.TaskDetail;
import com.avszoom.clientimitationservice.services.Task;
import com.avszoom.clientimitationservice.services.TaskImplBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.*;

@RestController
public class ClientImitationController {

    public static ConcurrentHashMap<Long, List<TaskDetail>> requestDetails = new ConcurrentHashMap<>();

    @Autowired
    ExecutionEngine executionEngine;

    @Autowired
    TaskImplBuilder taskImplBuilder;

    @GetMapping("/executeClient/{parallelRequest}")
    public String executeRequest(@PathVariable("parallelRequest") Integer requestsToMake) throws Exception{
        List<Task> taskList = taskImplBuilder.build(requestsToMake);
        return executionEngine.executeTask(taskList, requestsToMake);
    }
}
