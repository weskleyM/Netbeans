package com.ufc.main.repository;

import com.ufc.main.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

     public User findByEmail(String email);
}
