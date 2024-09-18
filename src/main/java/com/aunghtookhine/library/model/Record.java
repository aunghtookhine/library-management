package com.aunghtookhine.library.model;
import com.aunghtookhine.library.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

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


    public Record() {
    }

    public Record(LocalDate borrowDate, LocalDate returnDate, Status status) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
