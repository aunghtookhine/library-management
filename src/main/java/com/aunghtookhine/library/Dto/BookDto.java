package com.aunghtookhine.library.Dto;

import com.aunghtookhine.library.Enum.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record BookDto(
        @NotBlank
        String title,
        @NotBlank
        String author,
        @NotNull
        LocalDate publishedDate,
        @NotNull
        Genre genre,
        @Positive
        int quantity
) {
}
