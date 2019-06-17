package com.ufc.main.service;

import com.ufc.main.model.Role;
import com.ufc.main.model.User;
import com.ufc.main.repository.RoleRepository;
import com.ufc.main.repository.UserRepository;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

     @Autowired
     BCryptPasswordEncoder encoder;

     @Autowired
     RoleRepository roleRepository;

     @Autowired
     UserRepository userRepository;

     @Override
     public void saveUser(User user) {
          user.setSenha(encoder.encode(user.getSenha()));
          user.setStatus("VERIFIED");
          Role userRole = roleRepository.findByRole("SITE_USER");
          user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
          userRepository.save(user);
     }

     @Override
     public boolean isUserAlreadyPresent(User user) {
          boolean isUserAlreadyExists = false;
          User existingUser = userRepository.findByEmail(user.getEmail());
          // Verifica se usuario ja esta no BD
          if (existingUser != null) {
               isUserAlreadyExists = true;
          }
          return isUserAlreadyExists;
     }

}
