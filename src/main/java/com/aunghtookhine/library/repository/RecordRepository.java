package com.aunghtookhine.library.repository;

import com.aunghtookhine.library.enums.Status;
import com.aunghtookhine.library.model.Record;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    Record findByMemberIdAndBookIdAndStatus(@Positive Integer integer, @Positive Integer integer1, Status status);

    Optional<Record> findByIdAndIsAvailableTrue(Integer id);

    List<Record> findAllByIsAvailableTrue();

    List<Record> findAllByStatusAndIsAvailableTrue(Status status);

    List<Record> findAllByMemberIdAndReturnDateNull(Integer id);

    List<Record> findAllByBookIdAndReturnDateNull(Integer id);
}
