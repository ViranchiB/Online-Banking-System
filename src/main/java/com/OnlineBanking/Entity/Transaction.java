package com.OnlineBanking.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.OnlineBanking.Entity.Enums.TransactionStatus;
import com.OnlineBanking.Entity.Enums.TransactionType;
import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status = TransactionStatus.PENDING;

    @PrePersist
    protected void onCreate() {
        transactionDate = LocalDateTime.now();
    }
}
