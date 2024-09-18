package com.aunghtookhine.library.controller;

import com.aunghtookhine.library.dto.RecordDto;
import com.aunghtookhine.library.dto.RecordResponseDto;
import com.aunghtookhine.library.enums.Status;
import com.aunghtookhine.library.service.RecordService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/records")
@AllArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RecordResponseDto borrowBook(@Valid @RequestBody RecordDto dto){
        return recordService.borrowBook(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public RecordResponseDto returnBook(@Valid @RequestBody RecordDto dto){
        return recordService.returnBook(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<RecordResponseDto> findRecords(@RequestParam(required = false, value = "status")Status status){
        if (status != null){
            return recordService.findRecordsWithStatus(status);
        }
        return recordService.findRecords();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable("id") Integer id){
        recordService.deleteRecord(id);
    }
}
