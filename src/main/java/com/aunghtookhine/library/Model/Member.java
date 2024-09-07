package com.aunghtookhine.library.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.CreatedDate;
import java.time.Instant;

@Entity
public class Member extends BaseEntity {
    private String name;
    private String email;
    private String phone;
    @Column(updatable = false)
    @CreatedDate
    private Instant memberSince;

    public Member() {
    }

    public Member(String name, String email, String phone, Instant memberSince) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.memberSince = memberSince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instant getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Instant memberSince) {
        this.memberSince = memberSince;
    }
}
