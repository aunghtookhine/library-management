package com.aunghtookhine.library.entity;
import com.aunghtookhine.library.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Record extends BaseEntity{
    private LocalDate borrowDate = LocalDate.now();
    private LocalDate returnDate = null;
    @Enumerated(EnumType.STRING)
    private Status status = Status.borrowed;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
