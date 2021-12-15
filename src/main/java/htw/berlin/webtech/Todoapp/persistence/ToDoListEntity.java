package htw.berlin.webtech.Todoapp.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "toDos")
public class ToDoListEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name ="deadline")
    private LocalDate deadline;

    @Column(name = "completed")
    private boolean completed;

    public ToDoListEntity(String title, LocalDate deadline, boolean completed) {
        this.title = title;
        this.deadline = deadline;
        this.completed = completed;
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
