package br.com.todolist.services.user_service.edit_user_strategy;

import java.util.Optional;

import br.com.todolist.models.UserModel;

public interface EditUserStrategy {
    
    public void editUser(Optional<UserModel> user_data, UserModel edited_user);

}
