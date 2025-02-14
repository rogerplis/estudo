package com.roger.estudo.repositories;

import java.util.Optional;

import com.roger.estudo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);    

}
