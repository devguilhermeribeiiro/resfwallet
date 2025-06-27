package com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.RealEstateFund;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.Transaction;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.User;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.Wallet;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        return new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .addAnnotatedClass(Wallet.class)
            .addAnnotatedClass(RealEstateFund.class)
            .addAnnotatedClass(Transaction.class)
            .buildSessionFactory();
    }
}
