package com.harol.users.infraestructure.in.dtos;

public record UserDTO(
                Long id,
                String name,
                String lastname,
                String email,
                String phonenumber) {
}
