package com.harol.users.infraestructure.in.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserPatchDTO(
        @Size(min = 2, max = 20) String name,
        @Size(min = 2, max = 20) String lastname,
        @Email String email,
        String phonenumber) {
}
