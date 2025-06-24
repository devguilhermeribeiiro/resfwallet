package com.github.devguilhermeribeiiro.ResfWallet;

import io.javalin.Javalin;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.router.apiBuilder(() -> {
                
            });
        });
        System.out.println(new App().getGreeting());
    }
}
