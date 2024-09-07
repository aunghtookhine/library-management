package com.aunghtookhine.library.Model;
import com.aunghtookhine.library.Enum.Status;
import jakarta.persistence.Entity;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDate;

@Entity
public class Record extends BaseEntity{
    private LocalDate borrowDate;
    @ColumnDefault("null")
    private LocalDate returnDate;
    @ColumnDefault("borrowed")
    private Status status;

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
}
