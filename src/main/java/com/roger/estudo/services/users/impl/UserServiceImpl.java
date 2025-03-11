package com.roger.estudo.services.users.impl;

import com.roger.estudo.Dtos.user.UserDto;
import com.roger.estudo.model.User;
import com.roger.estudo.repositories.UserRepository;
import com.roger.estudo.services.users.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map(user -> {
            return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getActive(), user.getRole().name(), user.getLocked());
        }).toList();
        }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
}
