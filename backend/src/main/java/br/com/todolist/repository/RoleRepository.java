package br.com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.todolist.models.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    
    RoleModel findByName(String name);

}
