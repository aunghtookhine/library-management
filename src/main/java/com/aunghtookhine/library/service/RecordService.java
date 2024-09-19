package com.aunghtookhine.library.service;

import com.aunghtookhine.library.dto.RecordDto;
import com.aunghtookhine.library.dto.RecordResponseDto;
import com.aunghtookhine.library.enums.Status;
import java.util.List;

public interface RecordService {
    RecordResponseDto borrowBook(RecordDto dto);
    RecordResponseDto returnBook(RecordDto dto);
    List<RecordResponseDto> findRecords();
    List<RecordResponseDto> findRecordsWithStatus(Status status);
    void deleteRecord(Integer id);
}
