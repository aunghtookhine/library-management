package com.aunghtookhine.library.Mapper;
import com.aunghtookhine.library.Dto.RecordDto;
import com.aunghtookhine.library.Dto.RecordResponseDto;
import com.aunghtookhine.library.Model.Book;
import com.aunghtookhine.library.Model.Member;
import com.aunghtookhine.library.Model.Record;
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
