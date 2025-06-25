package com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.User;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        return new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();
    }
}
