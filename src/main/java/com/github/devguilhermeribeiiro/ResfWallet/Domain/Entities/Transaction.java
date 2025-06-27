package com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private final String ticker;

    @Column(nullable = false)
    private final String transactionType;

    @Column(nullable = false)
    private final BigDecimal price;

    @Column(nullable = false)
    private final short quantity;

    @Column(nullable = false)
    private final Date date;

    public Transaction() {}

    public Transaction(
        String ticker,
        String transactionType,
        BigDecimal price,
        Short quantity,
        Date date
    ) {
        this.ticker = ticker;
        this.transactionType = transactionType;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    public String getTicker() {
        return ticker;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public short getQuantity() {
        return quantity;
    }

    public Date getDate() {
        return date;
    }
}
