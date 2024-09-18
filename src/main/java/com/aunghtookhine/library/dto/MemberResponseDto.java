package com.aunghtookhine.library.dto;

import java.time.Instant;

public record MemberResponseDto(String name, String email, String phone, Instant memberSince) {
}
