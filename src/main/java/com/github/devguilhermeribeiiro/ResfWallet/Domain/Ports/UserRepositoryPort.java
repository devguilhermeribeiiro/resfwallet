package com.github.devguilhermeribeiiro.ResfWallet.Domain.Ports;

import java.util.Optional;
import java.util.UUID;

import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.User;

public interface UserRepositoryPort {
    Optional<User> findById(UUID id);
    User save(User user);
    User update(User user);
    byte deleteById(UUID id);
}
