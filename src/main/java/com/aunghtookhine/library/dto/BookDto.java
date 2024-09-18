package com.aunghtookhine.library.dto;

import com.aunghtookhine.library.enums.Genre;
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
