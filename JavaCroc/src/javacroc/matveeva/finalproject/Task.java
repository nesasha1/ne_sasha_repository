package javacroc.matveeva.finalproject;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task {
    private String taskName;
    private LocalDate date;
    private LocalTime time;

    public Task(String taskName, LocalDate date, LocalTime time) {
        this.taskName = taskName;
        this.date = date;
        this.time = time;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
