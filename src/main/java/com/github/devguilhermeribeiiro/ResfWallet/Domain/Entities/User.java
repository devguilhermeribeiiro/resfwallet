package com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities;

import java.util.HashSet;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private HashSet<Wallet> wallets = new HashSet<>();

    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
      return name;
    }

    public String getEmail() {
      return email;
    }

    public String getPassword() {
      return password;
    }

    public HashSet<Wallet> getWallets() {
      return wallets;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public void addWallet(Wallet wallet) {
      wallets.add(wallet);
    }
}
