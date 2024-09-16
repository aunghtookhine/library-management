package com.aunghtookhine.library.Model;

import com.aunghtookhine.library.Enum.Genre;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Book extends BaseEntity {
    @Column(unique = true)
    private String title;
    private String author;
    @Column(updatable = false)
    private LocalDate publishedDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private List<Record> records;

    public Book() {
    }

    public Book(String title, String author, LocalDate publishedDate, Genre genre, int quantity) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
