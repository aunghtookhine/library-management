package com.aunghtookhine.library.dto;

import com.aunghtookhine.library.enums.Status;

import java.time.LocalDate;

public record RecordResponseDto(
        String memberName,
        String bookName,
        Status status,
        LocalDate borrowDate,
        LocalDate returnDate
) {
}
