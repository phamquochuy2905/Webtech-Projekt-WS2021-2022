package htw.berlin.webtech.Todoapp.service;

import htw.berlin.webtech.Todoapp.api.ToDoCreateOrUpdateRequest;
import htw.berlin.webtech.Todoapp.api.ToDoList;
import htw.berlin.webtech.Todoapp.persistence.ToDoListEntity;
import htw.berlin.webtech.Todoapp.persistence.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> findAll() {

        List<ToDoListEntity> toDos = toDoListRepository.findAll();
        return toDos.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public ToDoList findById(Long id) {
        var todoEntity = toDoListRepository.findById(id);
        return todoEntity.map(this::transformEntity).orElse(null);
    }

    public ToDoList create(ToDoCreateOrUpdateRequest request) {
        var todoEntity = new ToDoListEntity(request.getTitle(), request.getDeadline(),
                request.isCompleted());
        todoEntity = toDoListRepository.save(todoEntity);
        return transformEntity(todoEntity);

    }

    public ToDoList update(Long id, ToDoCreateOrUpdateRequest request) {
        var todoEntityOptional = toDoListRepository.findById(id);
        if (todoEntityOptional.isEmpty()){
            return null;
        }

        var todoEntity =todoEntityOptional.get();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setDeadline(request.getDeadline());
        todoEntity.setCompleted(request.isCompleted());


        todoEntity = toDoListRepository.save(todoEntity);
        return transformEntity(todoEntity);
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

    private ToDoList transformEntity(ToDoListEntity todoEntity) {
        return new ToDoList(
                todoEntity.getId(),
                todoEntity.getTitle(),
                todoEntity.getDeadline(),
                todoEntity.isCompleted() );
    }
}
