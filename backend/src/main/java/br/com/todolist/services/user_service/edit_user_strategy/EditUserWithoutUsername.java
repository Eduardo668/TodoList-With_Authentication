package br.com.todolist.services.user_service.edit_user_strategy;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.todolist.models.UserModel;

@Service
public class EditUserWithoutUsername implements EditUserStrategy {

    @Override
    public void editUser(Optional<UserModel> user_data, UserModel edited_user) {
        if (edited_user.getUsername() == null){
            user_data.map(attr ->{
                attr.setUsername(user_data.get().getUsername());
                attr.setPassword(edited_user.getPassword());
                attr.setTasks(edited_user.getTasks());
                return user_data.get();
            });
        }
    }

    

   
    
    
}
