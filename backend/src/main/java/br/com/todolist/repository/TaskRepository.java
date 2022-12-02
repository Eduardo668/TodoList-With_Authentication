package br.com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.todolist.models.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    
}
