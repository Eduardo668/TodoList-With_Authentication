package br.com.todolist.services.task_service;

import java.util.List;

import br.com.todolist.models.TaskModel;

public interface TaskService {
    
    TaskModel createTask(TaskModel newTask);
    List<TaskModel> findAllTasks();
    void deleteTask(Long task_id);
    TaskModel updateTask(TaskModel edited_task, Long task_id); 
    TaskModel findTaskById(Long task_id);

}
