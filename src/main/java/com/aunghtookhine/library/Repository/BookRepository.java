package com.aunghtookhine.library.Repository;

import com.aunghtookhine.library.Dto.BookDto;
import com.aunghtookhine.library.Enum.Genre;
import com.aunghtookhine.library.Model.Book;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByIsAvailableTrue();

    Optional<Book> findByIdAndIsAvailableTrue(Integer id);

    Book findByTitle(@NotBlank String title);

    List<Book> findByAuthorContainingAndIsAvailableTrue(String author);

    List<Book> findByAuthorContainingAndGenreAndIsAvailableTrue(String author, Genre genre);

    List<Book> findByGenreAndIsAvailableTrue(Genre genre);
}