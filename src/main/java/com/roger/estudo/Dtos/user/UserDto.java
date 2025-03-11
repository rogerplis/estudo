package com.roger.estudo.Dtos.user;

public record UserDto(Long id, String firstName, String lastName, String email, Boolean active, String role, Boolean locked) {

}
