package com.avszoom.clientimitationservice.models;

public class TaskDetail {
    String threadName;
    Long timeElapsed;

    public TaskDetail() {
    }

    public TaskDetail(String threadName, Long timeElapsed) {
        this.threadName = threadName;
        this.timeElapsed = timeElapsed;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    @Override
    public String toString() {
        return "TaskDetail{" +
                "threadName='" + threadName + '\'' +
                ", timeElapsed=" + timeElapsed +
                '}';
    }
}
