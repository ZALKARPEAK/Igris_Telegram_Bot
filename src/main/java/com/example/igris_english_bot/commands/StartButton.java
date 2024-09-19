package com.example.igris_english_bot.commands;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import com.example.igris_english_bot.commands.handler.ButtonHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class StartButton implements ButtonHandler {
    private static final String NEXT_BUTTON_TEXT = "Далее";
    private static final String NEXT_BUTTON_CALLBACK_DATA = "next";
    private static final String[] WELCOME_MESSAGES = {
            "Здесь вы сможете улучшить свой словарный запас и выйти на новый уровень общения на английском",
            "Все что от вас требуется – 10 минут в день"};
    private static final String WELCOME_MESSAGE = "Woo-hoo! Запускаем процесс";

    @Override
    public void handle(long chatId, TelegramLongPollingBot bot) {
        for (String message : WELCOME_MESSAGES) {
            TelegramMessageHelper.sendMessage(chatId, message, bot);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        TelegramMessageHelper.sendMessageWithButton(chatId, WELCOME_MESSAGE,
                NEXT_BUTTON_TEXT, NEXT_BUTTON_CALLBACK_DATA, bot);
    }
}