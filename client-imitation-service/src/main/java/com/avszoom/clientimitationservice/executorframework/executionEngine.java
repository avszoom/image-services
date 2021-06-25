package com.avszoom.clientimitationservice.executorframework;

import com.avszoom.clientimitationservice.services.Task;

import java.util.List;

/*
* Take tasks of type Task and execute them with level of parallelDegree. It basically spawns those many threads
* but restricts parallelDegree to 100
*/
public interface ExecutionEngine {
    public String executeTask(List<Task> taskList, Integer parallelDegree) throws Exception;
}
