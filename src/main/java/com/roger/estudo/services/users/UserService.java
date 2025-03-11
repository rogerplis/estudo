package com.roger.estudo.services.users;

import com.roger.estudo.Dtos.user.UserDto;
import com.roger.estudo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();
    User update(User user);
    Optional<User> findById(Long id);
    User findByEmail(String email);
    void delete(Long id);

}
