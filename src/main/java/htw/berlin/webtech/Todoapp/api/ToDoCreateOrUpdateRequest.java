package htw.berlin.webtech.Todoapp.api;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ToDoCreateOrUpdateRequest {

    private long id;
    @Size(min = 3, message = "Provide a title with 3 characters or more.")
    private String title;
    private LocalDate deadline;
    private boolean completed;

    public ToDoCreateOrUpdateRequest(long id, String title, LocalDate deadline, boolean completed) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.completed = completed;
    }

    public ToDoCreateOrUpdateRequest() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
