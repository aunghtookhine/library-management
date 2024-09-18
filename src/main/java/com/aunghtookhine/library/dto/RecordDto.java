package com.aunghtookhine.library.dto;

import jakarta.validation.constraints.Positive;

public record RecordDto(
        @Positive
        Integer memberId,
        @Positive
        Integer bookId
) {
}
