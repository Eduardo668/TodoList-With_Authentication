package br.com.todolist.services.user_service.edit_user_strategy;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.todolist.models.UserModel;

@Service
public class EditUserWithoutTasks implements EditUserStrategy {

    @Override
    public void editUser(Optional<UserModel> user_data, UserModel edited_user) {
        if (edited_user.getTasks() == null){
            user_data.map(attr ->{
                attr.setPassword(edited_user.getPassword());
                attr.setUsername(edited_user.getUsername());
                attr.setTasks(user_data.get().getTasks());
                return user_data.get();
            });
        }
        
    }
    
}
