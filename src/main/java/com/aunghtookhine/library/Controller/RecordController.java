package com.aunghtookhine.library.Controller;

import com.aunghtookhine.library.Dto.RecordDto;
import com.aunghtookhine.library.Dto.RecordResponseDto;
import com.aunghtookhine.library.Enum.Status;
import com.aunghtookhine.library.Service.RecordService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/records")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

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
