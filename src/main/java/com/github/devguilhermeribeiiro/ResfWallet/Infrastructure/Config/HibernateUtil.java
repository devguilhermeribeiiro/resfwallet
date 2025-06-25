package com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Config;

import org.eclipse.jetty.server.Authentication.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        return new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();
    }
}
