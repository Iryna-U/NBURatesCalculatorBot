package com.github.iv.nbu_rates_calculator_bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class NBUbot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;
    private NBUClient nbUClient;

    @Autowired
    public NBUbot(NBUClient nbUClient) {
        this.nbUClient = nbUClient;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.equals("all")) {
                List<NBUResponseDto> all = nbUClient.getData();
                System.out.println(all);
            }

            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("You sent: " + message);
            sendMessage.setChatId(update.getMessage().getChatId());

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
