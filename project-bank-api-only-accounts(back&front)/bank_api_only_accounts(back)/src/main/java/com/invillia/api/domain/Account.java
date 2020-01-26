package com.invillia.api.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double balance;

    @Column
    private Double accountLimit;

    @Column(nullable = false)
    private Double maxLimit;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Account(Double balance, Double accountLimit, Double maxLimit) {
        this.balance = balance;
        this.accountLimit = accountLimit;
        this.maxLimit = maxLimit;
    }

    public Account(){

    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Double maxLimit) {
        this.maxLimit = maxLimit;
    }

    public Long getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(Double accountLimit) {
        this.accountLimit = accountLimit;
    }
}
