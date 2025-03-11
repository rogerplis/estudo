package com.roger.estudo.controllers.users;

import com.roger.estudo.Dtos.user.UserDto;
import com.roger.estudo.model.Role;
import com.roger.estudo.model.User;
import com.roger.estudo.services.users.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<?>> listAll(){
        if(service.findAll().isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(service.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarUser(@PathVariable(value = "id") Long id, @RequestBody UserDto userDto){
        if(service.findById(id).isPresent()){
            User user = service.findById(id).get();
            user.setId(userDto.id());
            user.setFirstName(userDto.firstName());
            user.setLastName(userDto.lastName());
            user.setEmail(userDto.email());
            user.setActive(userDto.active());
            user.setLocked(userDto.locked());
            user.setRole(Role.valueOf(userDto.role()));
            service.update(user);
            return ResponseEntity.ok("Usuario alterado com sucesso");
        }else
            return ResponseEntity.notFound().build();
    }

}
