package com.aunghtookhine.library.mapper;

import com.aunghtookhine.library.dto.RecordDto;
import com.aunghtookhine.library.dto.RecordResponseDto;
import com.aunghtookhine.library.model.Book;
import com.aunghtookhine.library.model.Member;
import com.aunghtookhine.library.model.Record;
import org.springframework.stereotype.Service;

@Service
public class RecordMapper {
    public Record toRecord(RecordDto dto){
        Record record = new Record();
        Book book = new Book();
        book.setId(dto.bookId());
        Member member = new Member();
        member.setId(dto.memberId());
        record.setBook(book);
        record.setMember(member);
        return record;
    }

    public RecordResponseDto toRecordResponseDto(Record record){
        return new RecordResponseDto(record.getMember().getName(), record.getBook().getTitle(), record.getStatus(), record.getBorrowDate(), record.getReturnDate());
    }
}
