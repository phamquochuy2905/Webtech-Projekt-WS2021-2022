package htw.berlin.webtech.Todoapp.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity (name = "toDoList")
public class ToDoListEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "task")
    private String title;

    @Column(name ="deadline")
    private LocalDate deadline;

    @Column(name = "completion status")
    private boolean completed;

    public ToDoListEntity(String title, LocalDate deadline, boolean isCompleted) {
        this.title = title;
        this.deadline = deadline;
        this.completed = isCompleted;
    }

    protected ToDoListEntity() {

    }

    public long getId() {
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
