package com.avszoom.clientimitationservice.executorframework;

import com.avszoom.clientimitationservice.models.TaskDetail;
import com.avszoom.clientimitationservice.services.Task;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ExecutionEngineImpl implements ExecutionEngine {

    private static final Logger log = Logger.getLogger(ExecutionEngine.class.getName());

    private final static Integer MAX_PARALLEL_DEGREE = 100;
    @Override
    public String executeTask(List<Task> taskList, Integer parallelDegree) throws Exception{

        ExecutorService executorService= Executors.newFixedThreadPool(parallelDegree > MAX_PARALLEL_DEGREE ?MAX_PARALLEL_DEGREE: parallelDegree);

        List<Callable<TaskDetail>> allTasks = taskList.stream()
                .map(task -> {
                    Callable<TaskDetail> ctask = () -> {
                        Long start = System.currentTimeMillis();
                        task.executeTask(Thread.currentThread().getName());
                        Long end = System.currentTimeMillis();
                        //ClientImitationController.requestDetails.get(ThreadGroup)
                        //  put(Thread.currentThread().getId(), new TaskDetail(Thread.currentThread().getName(),end-start));
                        return new TaskDetail(Thread.currentThread().getName(),end-start);
                    };
                    return ctask;
                }).collect(Collectors.toList());


        List<Future<TaskDetail>> fut = executorService.invokeAll(allTasks);

        executorService.shutdown();

        List<String> res = fut.stream()
                .map(f -> {
                    try {
                        return f.get().toString();
                    } catch (Exception e)
                    {
                        log.log(Level.SEVERE, e.getMessage());
                        return "error";
                    }
                })
                .collect(Collectors.toList());
        return res.toString();
    }
}
