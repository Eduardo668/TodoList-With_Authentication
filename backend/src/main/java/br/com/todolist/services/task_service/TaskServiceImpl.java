package br.com.todolist.services.task_service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.todolist.models.TaskModel;
import br.com.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskModel createTask(TaskModel newTask) {
        try {
            return taskRepository.save(newTask);
        } catch (Exception error) {
            throw new RuntimeException("An error ocurred while trying to create a task, error:", error);
        }
    }

    @Override
    public List<TaskModel> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long task_id) {
        try {
            Optional<TaskModel> task_data = taskRepository.findById(task_id);
            if (task_data.isEmpty()) {
                throw new RuntimeException("This task don't exists");
            }

            taskRepository.delete(task_data.get());

        } catch (Exception error) {
            throw new RuntimeException("An error ocurred while trying to delete a task", error);
        }

    }

    @Override
    public TaskModel updateTask(TaskModel edited_task, Long task_id) {
        try {
            Optional<TaskModel> task_data = taskRepository.findById(task_id);
            if (task_data.isEmpty()) {
                throw new RuntimeException("This task don't exists");
            }
            if (edited_task.getPriority() == null) {
                task_data.map(attr -> {
                    attr.setTitle(edited_task.getTitle());
                    attr.setPriority(task_data.get().getPriority());
                    return task_data.get();
                });
            } else if (edited_task.getTitle() == null) {
                task_data.map(attr -> {
                    attr.setTitle(task_data.get().getTitle());
                    attr.setPriority(edited_task.getPriority());
                    return task_data.get();
                });
            } else {
                task_data.map(attr -> {
                    attr.setTitle(edited_task.getTitle());
                    attr.setPriority(edited_task.getPriority());
                    return task_data.get();
                });
            }

            return taskRepository.save(task_data.get());

        } catch (Exception error) {
            throw new RuntimeException("An error ocurred while trying to update a task, error:", error);
        }
    }

    @Override
    public TaskModel findTaskById(Long task_id) {
        try {
            Optional<TaskModel> task_data = taskRepository.findById(task_id);
            if (task_data.isEmpty()) {
                throw new RuntimeException("This task don't exist");
            }

            return task_data.get();

        } catch (Exception error) {
            throw new RuntimeException("An error ocurred while trying to find a task by id, error:", error);
        }
    }

}
