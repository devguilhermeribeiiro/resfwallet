package com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Adapters.Persistence;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.github.devguilhermeribeiiro.ResfWallet.Application.Exceptions.NotFoundException;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.User;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Ports.UserRepositoryPort;

public class UserRepositoryHibernate implements UserRepositoryPort {
    private SessionFactory sessionFactory;

    public UserRepositoryHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<User> findById(UUID id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.find(User.class, id);
            transaction.commit();
            return Optional.ofNullable(user);
        }
    }

    @Override
    public User save(User user) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public User update(User user) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User updatedUser = session.merge(user);
            transaction.commit();
            return updatedUser;
        }
    }

    @Override
    public byte deleteById(UUID id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.find(User.class, id);
            if (user.equals(null)) {
                throw new NotFoundException("User not found");
            }
            session.remove(user);
            transaction.commit();
            
            // 0 == OK, anyother == 1
            return 0;
        }
    }
    
}
