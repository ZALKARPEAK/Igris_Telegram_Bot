package com.example.igris_english_bot.commands;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import static com.example.igris_english_bot.bot.button.message.TelegramMessageHelper.sendMessageWithButton;

public class StartCommand extends Command {
    private static final String START_BUTTON_TEXT = "Начать";
    private static final String START_BUTTON_CALLBACK_DATA = "starts";
    private static final String NEXT_BUTTON_TEXT = "Далее";
    private static final String NEXT_BUTTON_CALLBACK_DATA = "next";
    private static final String START_MESSAGE = "Привет, это Igris🙂";
    private static final String[] WELCOME_MESSAGES = {
            "Здесь вы сможете улучшить свой словарный запас и выйти на новый уровень общения на английском",
            "Все что от вас требуется – 10 минут в день"};

    protected StartCommand(String commandName) {
        super("start");
    }

    @Override
    public void execute(long chatId, String data, TelegramLongPollingBot bot) {
        sendMessageWithButton(chatId, START_MESSAGE, START_BUTTON_TEXT, START_BUTTON_CALLBACK_DATA, bot);

        for (String welcomeMessage : WELCOME_MESSAGES) {
            sendMessage(chatId, welcomeMessage, bot);
        }

        sendMessageWithButton(chatId, "Woo-hoo! Запускаем процесс", NEXT_BUTTON_TEXT, NEXT_BUTTON_CALLBACK_DATA, bot);
    }

    private void sendMessage(long chatId, String message, TelegramLongPollingBot bot) {
        TelegramMessageHelper.sendMessageWithButton(chatId, message, START_BUTTON_TEXT, START_BUTTON_CALLBACK_DATA,
                bot);
    }
}