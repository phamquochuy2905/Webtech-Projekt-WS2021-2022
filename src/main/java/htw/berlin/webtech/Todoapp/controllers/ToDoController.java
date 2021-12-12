package htw.berlin.webtech.Todoapp.controllers;

import com.sun.istack.NotNull;
import htw.berlin.webtech.Todoapp.persistence.ToDoListEntity;
import htw.berlin.webtech.Todoapp.persistence.ToDoListRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class ToDoController {

    private final ToDoListRepository toDoListRepository;

    public ToDoController(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @GetMapping
    public List<ToDoListEntity> findAll() {
        return toDoListRepository.findAll();
    }

    @PostMapping
    public ToDoListEntity save(@NotNull @RequestBody ToDoListEntity toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @PutMapping
    public ToDoListEntity update(@NotNull @RequestBody ToDoListEntity toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        toDoListRepository.deleteById(id);
    }
}
