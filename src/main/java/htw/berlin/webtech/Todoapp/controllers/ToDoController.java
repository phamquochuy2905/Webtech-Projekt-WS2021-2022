package htw.berlin.webtech.Todoapp.controllers;

import htw.berlin.webtech.Todoapp.api.ToDoCreateOrUpdateRequest;
import htw.berlin.webtech.Todoapp.api.ToDoList;
import htw.berlin.webtech.Todoapp.service.ToDoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ToDoController {

    private final ToDoListService todoService;

    public ToDoController(ToDoListService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "/api/v1/todos" )
    public ResponseEntity<List<ToDoList>> fetchTodo() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping(path = "/api/v1/todos/{id}")
    public ResponseEntity<ToDoList> fetchTodoById(@PathVariable Long id) {
        var todo = todoService.findById(id);
        return todo != null? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "api/v1/todos")
    public ResponseEntity<Void> createTodo(@RequestBody ToDoCreateOrUpdateRequest request) throws URISyntaxException {
        var todo = todoService.create(request);
        URI uri = new URI("api/v1/todos" + todo.getId() );
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/todos/{id}")
    public ResponseEntity<ToDoList> updateTodo(@PathVariable Long id, @RequestBody ToDoCreateOrUpdateRequest request){
        var todo = todoService.update(id, request);
        return todo != null? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        boolean successful = todoService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
