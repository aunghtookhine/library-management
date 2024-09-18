package com.aunghtookhine.library.service;

import com.aunghtookhine.library.dto.BookDto;
import com.aunghtookhine.library.enums.Genre;
import com.aunghtookhine.library.exception.BookNotFoundException;
import com.aunghtookhine.library.exception.DuplicateBookTitle;
import com.aunghtookhine.library.mapper.BookMapper;
import com.aunghtookhine.library.model.Book;
import com.aunghtookhine.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookDto createBook(BookDto dto) {
        Book checkBookTitleDuplicate = bookRepository.findByTitle(dto.title());
        if(checkBookTitleDuplicate != null) throw new DuplicateBookTitle("Book Title cannot be duplicated.");
        Book savedBook = bookRepository.save(bookMapper.toBook(dto));
        return bookMapper.toBookDto(savedBook);
    }

    public List<BookDto> findBooks() {
        return bookRepository.findAllByIsAvailableTrue().stream().map(bookMapper::toBookDto).collect(Collectors.toList());
    }

    public BookDto findBook(Integer id) {
        Book book = bookRepository.findByIdAndIsAvailableTrue(id).orElseThrow(()-> new BookNotFoundException("Invalid Book with Id: " + id));
        return bookMapper.toBookDto(book);
    }

    public BookDto updateBook(Integer id, BookDto dto) {
        Book book = bookRepository.findByIdAndIsAvailableTrue(id).orElseThrow(()-> new BookNotFoundException("Invalid Book with Id: " + id));
        Book checkBookTitleDuplicate = bookRepository.findByTitle(dto.title());
        if(checkBookTitleDuplicate != null && !Objects.equals(checkBookTitleDuplicate.getId(), id)){
            throw new DuplicateBookTitle("Book Title cannot be duplicated.");
        }
        book.setAuthor(dto.author());
        book.setTitle(dto.title());
        book.setPublishedDate(dto.publishedDate());
        book.setGenre(dto.genre());
        book.setQuantity(dto.quantity());
        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookDto(savedBook);
    }

    public void deleteBook(Integer id){
        Book book = bookRepository.findByIdAndIsAvailableTrue(id).orElseThrow(()-> new BookNotFoundException("Invalid Book with Id: " + id));
        book.setAvailable(false);
        bookRepository.save(book);
    }

    public List<BookDto> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingAndIsAvailableTrue(author).stream().map(bookMapper::toBookDto).collect(Collectors.toList());
    }

    public List<BookDto> findBooksByAuthorAndGenre(String author, Genre genre) {
        return bookRepository.findByAuthorContainingAndGenreAndIsAvailableTrue(author, genre).stream().map(bookMapper::toBookDto).collect(Collectors.toList());
    }

    public List<BookDto> findBooksByGenre(Genre genre) {
        return bookRepository.findByGenreAndIsAvailableTrue(genre).stream().map(bookMapper::toBookDto).collect(Collectors.toList());
    }
}
