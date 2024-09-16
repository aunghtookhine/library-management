package com.aunghtookhine.library.Mapper;

import com.aunghtookhine.library.Dto.BookDto;
import com.aunghtookhine.library.Model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public Book toBook(BookDto dto){
        Book book = new Book();
        book.setAuthor(dto.author());
        book.setTitle(dto.title());
        book.setPublishedDate(dto.publishedDate());
        book.setGenre(dto.genre());
        book.setQuantity(dto.quantity());
        return book;
    }

    public BookDto toBookDto(Book book){
        return new BookDto(book.getTitle(), book.getAuthor(), book.getPublishedDate(), book.getGenre(), book.getQuantity());
    }
}
