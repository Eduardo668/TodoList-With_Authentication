package br.com.todolist.services.user_service.edit_user_strategy;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.todolist.models.TaskModel;
import br.com.todolist.models.UserModel;

@Service
public class EditAllUser implements EditUserStrategy {

    @Override
    public void editUser(Optional<UserModel> user_data, UserModel edited_user) {
        String password = edited_user.getPassword();
        String username = edited_user.getUsername();
        List<TaskModel> tasks = edited_user.getTasks();
        if (password != null && username != null && tasks != null){
            user_data.map(attr ->{
                attr.setPassword(edited_user.getPassword());
                attr.setUsername(edited_user.getUsername());
                attr.setTasks(edited_user.getTasks());
                return user_data.get();
            });
        }
        
    }
     
}
