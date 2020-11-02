package correia.augusto.todorest.controllers;

import correia.augusto.todorest.models.TasksModel;
import correia.augusto.todorest.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/tasks")
public class TasksController {
    public final Integer STATUS_COMPLETED = 2;
    @Autowired
    TasksRepository tasksRepository;

   @PostMapping
    public TasksModel createTask(@RequestBody TasksModel task){
           return tasksRepository.save(task);
    }
    @GetMapping
    public Iterable<TasksModel> findAll(){
        return  tasksRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TasksModel> getTaskById(@PathVariable("id") Integer id) {
         return tasksRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
                 .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<TasksModel> updateTask(@PathVariable("id") Integer id, @RequestBody TasksModel task) {
        return tasksRepository.findById(id).map(record -> {
            record.clone(task);
            TasksModel updated = tasksRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Integer id) {
       return tasksRepository.findById(id).map(record -> {
           if(record.getStatus() == STATUS_COMPLETED){return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
           tasksRepository.delete(record);
           return ResponseEntity.ok().body(HttpStatus.OK);
       }).orElse(ResponseEntity.notFound().build());
    }

}

