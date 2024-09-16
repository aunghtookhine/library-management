package com.aunghtookhine.library.Service;

import com.aunghtookhine.library.Dto.RecordDto;
import com.aunghtookhine.library.Dto.RecordResponseDto;
import com.aunghtookhine.library.Enum.Status;
import com.aunghtookhine.library.Exception.*;
import com.aunghtookhine.library.Mapper.RecordMapper;
import com.aunghtookhine.library.Model.Book;
import com.aunghtookhine.library.Model.Member;
import com.aunghtookhine.library.Model.Record;
import com.aunghtookhine.library.Repository.BookRepository;
import com.aunghtookhine.library.Repository.MemberRepository;
import com.aunghtookhine.library.Repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {
    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public RecordService(RecordRepository recordRepository, RecordMapper recordMapper, MemberRepository memberRepository, BookRepository bookRepository) {
        this.recordRepository = recordRepository;
        this.recordMapper = recordMapper;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public RecordResponseDto borrowBook(RecordDto dto) {
        Member member = memberRepository.findByIdAndIsAvailableTrue(dto.memberId()).orElseThrow(()-> new MemberNotFoundException("Invalid Member with Id: "+ dto.memberId()));
        Book book = bookRepository.findByIdAndIsAvailableTrue(dto.bookId()).orElseThrow(()-> new BookNotFoundException("Invalid Book with Id: " + dto.bookId()));
        if(book.getQuantity() < 1) throw new NoBookLeftToBorrowException("Insufficient book to borrow");

        Record record = recordRepository.findByMemberIdAndBookIdAndStatus(dto.memberId(), dto.bookId(), Status.borrowed);
        if(record != null){
            throw new AlreadyBorrowedException("You've already borrowed this book.");
        }
        Record savedRecord = recordRepository.save(recordMapper.toRecord(dto));
        savedRecord.setMember(member);
        savedRecord.setBook(book);
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
        return recordMapper.toRecordResponseDto(savedRecord);
    }

    public RecordResponseDto returnBook(RecordDto dto){
        memberRepository.findById(dto.memberId()).orElseThrow(()-> new MemberNotFoundException("Invalid Member with Id: "+ dto.memberId()));
        Book book = bookRepository.findById(dto.bookId()).orElseThrow(()-> new BookNotFoundException("Invalid Book with Id: " + dto.bookId()));
        Record record = recordRepository.findByMemberIdAndBookIdAndStatus(dto.memberId(), dto.bookId(), Status.borrowed);
        if(record == null){
            throw new RecordNotFoundException("There's no record with Member Id: " + dto.memberId() + " and Book Id: " + dto.bookId());
        }
        record.setReturnDate(LocalDate.now());
        record.setStatus(Status.returned);
        Record savedRecord = recordRepository.save(record);
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        return recordMapper.toRecordResponseDto(savedRecord);
    }

    public List<RecordResponseDto> findRecords() {
        return recordRepository.findAllByIsAvailableTrue().stream().map(recordMapper::toRecordResponseDto).collect(Collectors.toList());
    }

    public List<RecordResponseDto> findRecordsWithStatus(Status status) {
        return recordRepository.findAllByStatusAndIsAvailableTrue(status).stream().map(recordMapper::toRecordResponseDto).collect(Collectors.toList());
    }

    public void deleteRecord(Integer id) {
        Record record = recordRepository.findByIdAndIsAvailableTrue(id).orElseThrow(() -> new RecordNotFoundException("Invalid Record with Id: " + id));
        if(record.getStatus().equals(Status.borrowed)){
            throw new UnreturnedBookException("Record of unreturned book cannot be deleted.");
        }
        record.setAvailable(false);
        recordRepository.save(record);
    }
}
