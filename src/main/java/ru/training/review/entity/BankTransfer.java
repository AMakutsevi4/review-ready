package ru.training.review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Bank_profit")
public class BankTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double profitRub;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;

    public BankTransfer(double profitRub, LocalDateTime transactionTime) {
        this.profitRub = profitRub;
        this.transactionTime = transactionTime;
    }

}
