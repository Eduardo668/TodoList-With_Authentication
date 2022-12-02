package br.com.todolist.services.role_service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.todolist.models.RoleModel;
import br.com.todolist.models.UserModel;
import br.com.todolist.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleModel createRole(RoleModel newRole) {
        try{
            return roleRepository.save(newRole);
        } catch (Exception error){
            throw new RuntimeException("An error ocurred while trying to create a role, error:", error);
        }
    }

    @Override
    public List<RoleModel> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleModel findByRoleName(String role_name) {
        try{
            RoleModel role_data = roleRepository.findByName(role_name);
            if (role_data == null){
                throw new RuntimeException("This role don't exists");
            }

            return role_data;

        } catch(Exception error){
            throw new RuntimeException("An error ocurred while trying to find a role by name, error:", error);
        }
    }

    @Override
    public void updateRole(List<UserModel> user_list,String role_name) {
        try {
            RoleModel role_data = roleRepository.findByName(role_name);
            if (role_data == null){
                throw new RuntimeException("This role don't exists");
            }

            role_data.setName(role_data.getName());
            roleRepository.save(role_data);


        } catch (Exception error) {
            throw new RuntimeException("An error ocurred while trying to update a role, error:", error);
        }
        
    }
    
}
