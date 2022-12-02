package br.com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.todolist.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
    UserModel findByUsername(String username);

}
