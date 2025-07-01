package com.github.devguilhermeribeiiro.ResfWallet.Domain.Ports;

import java.util.Optional;

import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.Transaction;

public interface TransactionRepositoryPort {
  Optional<Transaction> findById(Long id);
  Transaction save(Transaction transaction);
}
