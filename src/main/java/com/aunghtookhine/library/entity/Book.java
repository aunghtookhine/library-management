package com.aunghtookhine.library.entity;

import com.aunghtookhine.library.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
