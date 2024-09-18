package com.aunghtookhine.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
public class Member extends BaseEntity {
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @Column(updatable = false)
    @CreationTimestamp
    private Instant memberSince;

    @OneToMany(mappedBy = "member")
    private List<Record> records;

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
