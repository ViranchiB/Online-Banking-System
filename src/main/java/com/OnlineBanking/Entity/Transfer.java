package com.OnlineBanking.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.OnlineBanking.Entity.Enums.TransferStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;

    @ManyToOne
    @JoinColumn(name = "sender_account_id", nullable = false)
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id", nullable = false)
    private Account receiverAccount;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "transfer_date")
    private LocalDateTime transferDate;

    @Enumerated(EnumType.STRING)
    private TransferStatus status = TransferStatus.PENDING;

    @PrePersist
    protected void onCreate() {
        transferDate = LocalDateTime.now();
    }
}
