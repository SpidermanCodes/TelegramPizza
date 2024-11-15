package com.example.TelegramPizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TelegramPizzaApplication {

    @Autowired
    private PizzaBot pizzaBot;

    public static void main(String[] args) {
        SpringApplication.run(TelegramPizzaApplication.class, args);
    }

    @Bean
    public CommandLineRunner startBot() {
        return args -> {
            try {
                TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
                botsApi.registerBot(pizzaBot);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        };
    }
}
