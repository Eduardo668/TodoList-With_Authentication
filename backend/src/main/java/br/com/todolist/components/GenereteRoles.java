package br.com.todolist.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.todolist.models.RoleModel;
import br.com.todolist.services.role_service.RoleServiceImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class GenereteRoles implements CommandLineRunner {

    private final RoleServiceImpl roleService;

    @Override
    public void run(String... args) throws Exception {
        
        RoleModel role_user = new RoleModel();
        role_user.setName("ROLE_USER");
        
        RoleModel role_admin = new RoleModel();
        role_admin.setName("ROLE_ADMIN");

        if (roleService.findAllRoles().isEmpty()){
            roleService.createRole(role_user);
            roleService.createRole(role_admin);
        }

        


        
    }
    
}
