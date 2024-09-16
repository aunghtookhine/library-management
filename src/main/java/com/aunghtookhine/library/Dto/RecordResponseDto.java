package com.aunghtookhine.library.Dto;

import com.aunghtookhine.library.Enum.Status;

import java.time.LocalDate;

public record RecordResponseDto(
        String memberName,
        String bookName,
        Status status,
        LocalDate borrowDate,
        LocalDate returnDate
) {
}
