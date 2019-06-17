package com.ufc.main.repository;

import com.ufc.main.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

     public Role findByRole(String role);
}
