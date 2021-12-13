package htw.berlin.webtech.Todoapp.api;

import java.time.LocalDate;

public class ToDoList {

    private long id;
    private String title;
    private LocalDate deadline;
    private boolean completed;

    public ToDoList(long id, String title, LocalDate deadline, boolean completed) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
