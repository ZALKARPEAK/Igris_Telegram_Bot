package com.example.igris_english_bot.commands.handler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public interface ButtonHandler {
    void handle(long chatId, TelegramLongPollingBot bot);
}
