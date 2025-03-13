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

    public Transfer() {
    }

    public Transfer(Long transferId, Account senderAccount, Account receiverAccount, BigDecimal amount, LocalDateTime transferDate, TransferStatus status) {
        this.transferId = transferId;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.transferDate = transferDate;
        this.status = status;
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public void setStatus(TransferStatus status) {
        this.status = status;
    }
}
