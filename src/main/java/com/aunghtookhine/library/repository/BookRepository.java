package com.aunghtookhine.library.repository;

import com.aunghtookhine.library.enums.Genre;
import com.aunghtookhine.library.model.Book;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
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