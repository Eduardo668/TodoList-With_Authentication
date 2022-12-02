package br.com.todolist.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.models.TaskModel;
import br.com.todolist.models.UserModel;
import br.com.todolist.services.user_service.UserServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/create")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel newUser) {
        return ResponseEntity.ok().body(userService.createUser(newUser));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<UserModel>> findAllUser() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @DeleteMapping("/delete/id={user_id}")
    public void deleteUser(@PathVariable Long user_id){
        userService.deleteUser(user_id);
    }

    @PutMapping("/update/id={user_id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long user_id, @RequestBody UserModel edited_user){
        return ResponseEntity.ok().body(userService.updateUser(edited_user, user_id));
    }

    @PutMapping("/add-task/id={user_id}")
    public ResponseEntity<UserModel> userCreateTask(@RequestBody TaskModel newTask, @PathVariable Long user_id){
        return ResponseEntity.ok().body(userService.addTask(newTask, user_id)) ;
    }

    @GetMapping("/findUserById/id={user_id}")
    public ResponseEntity<UserModel> findUserById(@PathVariable Long user_id){
        return ResponseEntity.ok().body(userService.findUserById(user_id));
    }
 
}
