package br.com.todolist.services.user_service;

import java.util.List;

import br.com.todolist.models.TaskModel;
import br.com.todolist.models.UserModel;

public interface UserService {
    
    UserModel createUser(UserModel newUser);
    List<UserModel> findAllUsers();
    void deleteUser(Long user_id);
    UserModel updateUser(UserModel edited_user, Long user_id);
    UserModel addTask(TaskModel newTask, Long user_id);
    UserModel findUserById(Long user_id);
    

}
