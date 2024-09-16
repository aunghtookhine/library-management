package com.aunghtookhine.library.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record MemberDto(
        @NotBlank
        String name,
        @Email
        @NotBlank
        String email,
        @Pattern(regexp = "^09\\d{9}$", message = "Phone number must start with '09' followed by 9 digits.")
        @NotBlank
        String phone
) {
}
