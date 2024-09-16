package com.example.igris_english_bot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.example.igris_english_bot.bot.button.message.TelegramMessageHelper.sendMessageWithButton;

public class StartCommand extends Command {
    private static final String NEXT_BUTTON_TEXT = "Далее";
    private static final String NEXT_BUTTON_CALLBACK_DATA = "next";
    private static final String START_MESSAGE = "Привет, это Igris🙂";
    private static final String[] WELCOME_MESSAGES = {
            "Здесь вы сможете улучшить свой словарный запас и выйти на новый уровень общения на английском",
            "Все что от вас требуется – 10 минут в день"};


    public StartCommand() {
        super("starts");
    }

    @Override
    public void execute(long chatId, String data, TelegramLongPollingBot bot) {
        sendWelcomeMessages(chatId);
        sendMessageWithButton(chatId, "Woo-hoo! Запускаем процесс",
                NEXT_BUTTON_TEXT, NEXT_BUTTON_CALLBACK_DATA, bot);
    }

    private void sendWelcomeMessages(long chatId) {
        for (String message : WELCOME_MESSAGES) {
            sendMessage(chatId, message);
        }
    }

    private void sendMessage(long chatId, String message) {
        SendMessage messageToSend = new SendMessage();
        messageToSend.setChatId(chatId);
        messageToSend.setText(message);
    }
}