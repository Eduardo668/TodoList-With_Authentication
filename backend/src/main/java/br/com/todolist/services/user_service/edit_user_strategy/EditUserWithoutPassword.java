package br.com.todolist.services.user_service.edit_user_strategy;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.todolist.models.UserModel;

@Service
public class EditUserWithoutPassword implements EditUserStrategy {

    @Override
    public void editUser(Optional<UserModel> user_data, UserModel edited_user) {
        if (edited_user.getPassword() == null){
            user_data.map(attr ->{
                attr.setPassword(user_data.get().getPassword());
                attr.setUsername(edited_user.getUsername());
                attr.setTasks(edited_user.getTasks());
                return user_data.get();
            });
        }
        
    }
    
}
