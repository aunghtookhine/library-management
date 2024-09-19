package com.aunghtookhine.library.controller;

import com.aunghtookhine.library.dto.BookDto;
import com.aunghtookhine.library.enums.Genre;
import com.aunghtookhine.library.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookServiceImpl;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BookDto createBook(@Valid @RequestBody BookDto dto){
        return bookServiceImpl.createBook(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<BookDto> findBooks(@RequestParam(value = "author", required = false) String author, @RequestParam(value = "genre", required = false) Genre genre){
        if(author != null && genre != null){
            return bookServiceImpl.findBooksByAuthorAndGenre(author, genre);
        }else if (author != null){
            return bookServiceImpl.findBooksByAuthor(author);
        }else if (genre != null){
            return bookServiceImpl.findBooksByGenre(genre);
        }else{
            return bookServiceImpl.findBooks();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public BookDto findBook(@PathVariable("id") Integer id){
        return bookServiceImpl.findBook(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable("id") Integer id, @Valid @RequestBody BookDto dto){
        return bookServiceImpl.updateBook(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Integer id){
        bookServiceImpl.deleteBook(id);
    }
}
