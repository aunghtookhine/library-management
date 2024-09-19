package com.aunghtookhine.library.service;

import com.aunghtookhine.library.dto.BookDto;
import com.aunghtookhine.library.enums.Genre;
import java.util.List;


public interface BookService {
    BookDto createBook(BookDto dto);
    List<BookDto> findBooks();
    BookDto findBook(Integer id);
    BookDto updateBook(Integer id, BookDto dto);
    void deleteBook(Integer id);
    List<BookDto> findBooksByAuthor(String author);
    List<BookDto> findBooksByAuthorAndGenre(String author, Genre genre);
    List<BookDto> findBooksByGenre(Genre genre);
}
