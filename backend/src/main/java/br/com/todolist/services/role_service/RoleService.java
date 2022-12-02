package br.com.todolist.services.role_service;

import java.util.List;

import br.com.todolist.models.RoleModel;
import br.com.todolist.models.UserModel;

public interface RoleService {

    RoleModel createRole(RoleModel newRole);
    List<RoleModel> findAllRoles();
    RoleModel findByRoleName(String role_name);
    void updateRole(List<UserModel> user, String role_name);

}
