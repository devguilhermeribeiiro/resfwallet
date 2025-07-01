package com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Adapters.Persistence;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.Transaction;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Ports.TransactionRepositoryPort;

public class TransactionRepositoryHibernate implements TransactionRepositoryPort {
    private SessionFactory sessionFactory;

    public TransactionRepositoryHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            Transaction transactionObject = session.find(Transaction.class, id);
            transaction.commit();

            return Optional.ofNullable(transactionObject);
        }
    }

    @Override
    public Transaction save(Transaction transactionObject) {
        try (Session session = sessionFactory.openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            session.persist(transactionObject);
            transaction.commit();

            return transactionObject;
        }
    }

}
