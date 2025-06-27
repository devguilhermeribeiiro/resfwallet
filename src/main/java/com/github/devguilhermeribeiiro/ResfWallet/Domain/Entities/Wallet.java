package com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities;

import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private HashSet<RealEstateFund> funds = new HashSet<>();

    public Wallet() {}

    public Wallet(
        String name
    ) {
        this.name = name;
    }

    public Long getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public HashSet<RealEstateFund> getFunds() {
      return funds;
    }

    public void addFund(RealEstateFund fund) {
        funds.add(fund);
    }

    public void alterName(String newName) {
        name = newName;
    }
}
