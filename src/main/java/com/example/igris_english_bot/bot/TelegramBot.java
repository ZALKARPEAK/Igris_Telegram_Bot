package com.example.igris_english_bot.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "Igris_eNGLISH_bot";
    private static final String BOT_TOKEN = "7030874805:AAGuagul61MveOCc5p2rY2tM8BCMES4Gn38";

    private static final String START_MESSAGE = "Привет, это Igris🙂";
    private static final String UNKNOWN_COMMAND_MESSAGE = "Неизвестная команда. Попробуйте /start";

    private static final String[] WELCOME_MESSAGES = {
            "Здесь вы сможете улучшить свой словарный запас и выйти на новый уровень общения на английском",
            "Все что от вас требуется – 10 минут в день"
    };

    private static final String NEXT_QUESTION_MESSAGE = "Как думаете, сколько слов на английском достаточно знать, чтобы понимать носителей языка, смотреть Netflix в оригинале и чувствовать себя комфортно, проживая заграницей?";

    private static final String START_BUTTON_TEXT = "Начать";
    private static final String START_BUTTON_CALLBACK_DATA = "starts";
    private static final String NEXT_BUTTON_CALLBACK_DATA = "next";

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            handleTextMessage(update);
        } else if (update.hasCallbackQuery()) {
            handleCallbackQuery(update);
        }
    }

    private void handleTextMessage(Update update) {
        String messageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();

        if (messageText.equalsIgnoreCase("/start")) {
            sendMessageWithButton(chatId, START_MESSAGE);
        } else {
            sendMessage(chatId, UNKNOWN_COMMAND_MESSAGE);
        }
    }
    private void handleCallbackQuery(Update update) {
        String data = update.getCallbackQuery().getData();
        long chatId = update.getCallbackQuery().getMessage().getChatId();

        if (data.equals(START_BUTTON_CALLBACK_DATA)) {
            sendWelcomeMessages(chatId);
            sendMessageNextFunction(chatId, "Woo-hoo! Запускаем процесс");
        } else if (data.equals(NEXT_BUTTON_CALLBACK_DATA)) {
            sendMessage(chatId, NEXT_QUESTION_MESSAGE);
        }
    }

/*
    private void handle
*/

    private void sendWelcomeMessages(long chatId) {
        for (String message : WELCOME_MESSAGES) {
            sendMessage(chatId, message);
        }
    }

    private void sendMessageNextFunction(long chatId, String message) {
        SendMessage messageToSend = new SendMessage();
        messageToSend.setChatId(chatId);
        messageToSend.setText(message);

        InlineKeyboardMarkup markup = createInlineKeyboardMarkup("Далее", NEXT_BUTTON_CALLBACK_DATA);
        messageToSend.setReplyMarkup(markup);

        try {
            execute(messageToSend);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageWithButton(long chatId, String message) {
        SendMessage messageToSend = new SendMessage();
        messageToSend.setChatId(chatId);
        messageToSend.setText(message);

        InlineKeyboardMarkup markup = createInlineKeyboardMarkup(START_BUTTON_TEXT, START_BUTTON_CALLBACK_DATA);
        messageToSend.setReplyMarkup(markup);

        try {
            execute(messageToSend);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private InlineKeyboardMarkup createInlineKeyboardMarkup(String buttonText, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(buttonText);
        button.setCallbackData(callbackData);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(List.of(button));

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(keyboard);

        return markup;
    }

    private void sendMessage(long chatId, String message) {
        SendMessage messageToSend = new SendMessage();
        messageToSend.setChatId(chatId);
        messageToSend.setText(message);

        try {
            execute(messageToSend);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}