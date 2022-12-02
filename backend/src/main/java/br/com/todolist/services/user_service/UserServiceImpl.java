package br.com.todolist.services.user_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.todolist.models.RoleModel;
import br.com.todolist.models.TaskModel;
import br.com.todolist.models.UserModel;
import br.com.todolist.repository.UserRepository;
import br.com.todolist.services.role_service.RoleServiceImpl;
import br.com.todolist.services.task_service.TaskServiceImpl;
import br.com.todolist.services.user_service.edit_user_strategy.EditAllUser;
import br.com.todolist.services.user_service.edit_user_strategy.EditUserWithoutPassword;
import br.com.todolist.services.user_service.edit_user_strategy.EditUserWithoutTasks;
import br.com.todolist.services.user_service.edit_user_strategy.EditUserWithoutUsername;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TaskServiceImpl taskService;
    private final EditUserWithoutUsername editUserWithoutUsername;
    private final EditUserWithoutPassword editUserWithoutPassword;
    private final EditUserWithoutTasks editUserWithoutTasks;
    private final EditAllUser editAllUsers;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleServiceImpl roleService;

    
    @Override
    public UserModel createUser(UserModel newUser) {
        try {
            UserModel user_data = userRepository.findByUsername(newUser.getUsername());
            if (user_data != null) {
                throw new RuntimeException("This username already being used");
            }
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

            List<RoleModel> roles = new ArrayList<>();
            roles.add(roleService.findByRoleName("ROLE_USER"));
            
            newUser.setRoles(roles);

            return userRepository.save(newUser);

        } catch (Exception error) {
            throw new RuntimeException("An error ocurred when try to create a user, error:", error);
        }
    }

    @Override
    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long user_id) {
        try {
            Optional<UserModel> user_data = userRepository.findById(user_id);
            if (user_data.isEmpty()) {
                throw new RuntimeException("This user don't exists");
            }

            userRepository.delete(user_data.get());

        } catch (Exception error) {
            throw new RuntimeException("An error ocurred when try to delete a user, error:", error);
        }

    }

    @Override
    public UserModel updateUser(UserModel edited_user, Long user_id) {
        try {
            Optional<UserModel> user_data = userRepository.findById(user_id);

            editUserWithoutUsername.editUser(user_data, edited_user);
            editUserWithoutPassword.editUser(user_data, edited_user);
            editUserWithoutTasks.editUser(user_data, edited_user);
            editAllUsers.editUser(user_data, edited_user);

            return userRepository.save(user_data.get());

        } catch (Exception error) {
            throw new RuntimeException("An error occurred while trying update the user, error:", error);
        }
    }

    @Override
    public UserModel addTask(TaskModel newTask, Long user_id) {
        try {
            Optional<UserModel> user_data = userRepository.findById(user_id);
            if (user_data.isEmpty()) {
                throw new RuntimeException("This user don't exists");
            }

            newTask.setUser_task(user_data.get());
            taskService.createTask(newTask);

            return user_data.get();

        } catch (Exception error) {
            throw new RuntimeException("An error ocurred while trying to add task for a user, error:", error);
        }
    }

    @Override
    public UserModel findUserById(Long user_id) {
         try {
            Optional<UserModel> user_data = userRepository.findById(user_id);
            if (user_data.isEmpty()){
                throw new RuntimeException("This user don't exists");
            }
            return user_data.get();
         } catch (Exception error) {
            throw new RuntimeException("An error ocurred while trying to find a user by id, error:", error);
         }
    }

}
