package com.aunghtookhine.library.Dto;

import jakarta.validation.constraints.Positive;

public record RecordDto(
        @Positive
        Integer memberId,
        @Positive
        Integer bookId
) {
}
