package com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "real_estate_funds")
public class RealEstateFund {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ticker;

    @Column(nullable = false)
    private short quantity;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public RealEstateFund() {}

    public RealEstateFund(
        String name,
        String ticker,
        Short quantity
    ) {
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
    }

    public Long getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public String getTicker() {
      return ticker;
    }

    public short getQuantity() {
      return quantity;
    }

    public Set<Transaction> getTransactions() {
      return transactions;
    }

    public void addTransaction(Transaction transaction) {
      transactions.add(transaction);
    }
}
