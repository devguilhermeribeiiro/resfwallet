package com.github.devguilhermeribeiiro.ResfWallet;

import org.hibernate.SessionFactory;

import com.github.devguilhermeribeiiro.ResfWallet.Application.Services.UserService;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Ports.UserRepositoryPort;
import com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Adapters.Persistence.UserRepositoryHibernate;
import com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Adapters.Web.UserController;
import com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Config.HibernateUtil;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class App {
    public static String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SessionFactory session = HibernateUtil.buildSessionFactory();
        UserRepositoryPort userRepository = new UserRepositoryHibernate(session);
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        Javalin app = Javalin.create(config -> {
            config.router.apiBuilder(() -> {
                path("/users", () -> {
                    post(userController.createUser);
                    get(userController.getUser);
                    patch(userController.updateUser);
                    delete(userController.deleteUser);
                });
            });
        });

        app.start(8080);

        System.out.println(App.getGreeting());
    }
}
