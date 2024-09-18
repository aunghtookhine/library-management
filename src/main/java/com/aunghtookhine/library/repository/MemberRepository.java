package com.aunghtookhine.library.repository;

import com.aunghtookhine.library.model.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findAllByIsAvailableTrue();

    Optional<Member> findByIdAndIsAvailableTrue(Integer id);

    Member findByEmail(@Email @NotBlank String email);

    Member findByPhone(@Pattern(regexp = "^09\\d{9}$", message = "Phone number must start with '09' followed by 9 digits.") @NotBlank String phone);
}
