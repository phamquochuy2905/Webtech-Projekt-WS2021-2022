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
    private Long id;

    @Column(name = "task")
    private String title;

    @Column(name ="deadline")
    private LocalDate deadline;

    @Column(name = "completion status")
    private boolean isCompleted;

    public ToDoListEntity(String title, LocalDate deadline, boolean isCompleted) {
        this.title = title;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
    }

    public ToDoListEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String toDoThing) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = isCompleted;
    }
}
