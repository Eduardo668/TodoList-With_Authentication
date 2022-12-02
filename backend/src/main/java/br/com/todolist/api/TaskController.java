package br.com.todolist.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.models.TaskModel;
import br.com.todolist.services.task_service.TaskServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {

    private final TaskServiceImpl taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel newTask) {
        return ResponseEntity.ok().body(taskService.createTask(newTask));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<TaskModel>> findAllTasks(){
        return ResponseEntity.ok().body(taskService.findAllTasks());
    }

    @DeleteMapping("/delete/id={task_id}")
    public void deleteTask(@PathVariable Long task_id){
        taskService.deleteTask(task_id);
    } 

    @PutMapping("/update/id={task_id}")
    public ResponseEntity<TaskModel> updateTask(@RequestBody TaskModel edited_task, @PathVariable Long task_id){
        return ResponseEntity.ok().body(taskService.updateTask(edited_task, task_id));
    }



}
