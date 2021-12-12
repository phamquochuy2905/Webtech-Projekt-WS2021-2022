package htw.berlin.webtech.Todoapp.service;

import htw.berlin.webtech.Todoapp.api.ToDoList;
import htw.berlin.webtech.Todoapp.persistence.ToDoListEntity;
import htw.berlin.webtech.Todoapp.persistence.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoListEntity> findAll(String user) {

        var toDoThings = new ArrayList<ToDoListEntity>();
        var iterator = toDoListRepository.findAll();
        for(ToDoListEntity a : iterator) {
            
        }

        return toDoThings;
    }

    public void add(String toDoThing, LocalDate deadline, boolean isCompleted) {
        ToDoListEntity newToDo = new ToDoListEntity(toDoThing, deadline, isCompleted);
        toDoListRepository.save(newToDo);
    }

    public boolean deleteById(Long id) {
        if (!toDoListRepository.existsById(id)) {
            return false;
        }
        toDoListRepository.deleteById(id);
        return true;
    }

    public void deleteAll() {
        toDoListRepository.deleteAll();
    }

    public ToDoListEntity save(ToDoListEntity toDoListEntity) {
        toDoListRepository.save(toDoListEntity);
        return toDoListEntity;
    }
}
