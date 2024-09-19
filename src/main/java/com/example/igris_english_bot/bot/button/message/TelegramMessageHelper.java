package com.example.igris_english_bot.bot.button.message;

import com.example.igris_english_bot.bot.button.Button;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.igris_english_bot.bot.button.generator.ButtonGeneration.createInlineKeyboardMarkup;

public class TelegramMessageHelper {
    public static void sendMessageWithButton(long chatId, String message, String buttonText, String callbackData, TelegramLongPollingBot bot) {
        SendMessage messageToSend = new SendMessage();
        messageToSend.setChatId(chatId);
        messageToSend.setText(message);

        Button button = new Button(buttonText, callbackData);

        InlineKeyboardMarkup keyboardMarkup = createInlineKeyboardMarkup(Collections.singletonList(button));
        messageToSend.setReplyMarkup(keyboardMarkup);

        try {
            bot.execute(messageToSend);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageWithButtons(long chatId, String message, String[] buttonTexts, String[] callbackData, TelegramLongPollingBot bot) {
        SendMessage messageToSend = new SendMessage();
        messageToSend.setChatId(chatId);
        messageToSend.setText(message);

        List<Button> buttons = new ArrayList<>();

        for (int i = 0; i < buttonTexts.length; i++) {
            Button button = new Button(buttonTexts[i], callbackData[i]);
            buttons.add(button);
        }

        InlineKeyboardMarkup keyboardMarkup = createInlineKeyboardMarkup(buttons);
        messageToSend.setReplyMarkup(keyboardMarkup);

        try {
            bot.execute(messageToSend);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(long chatId, String message, TelegramLongPollingBot bot) {
        SendMessage messageToSend = new SendMessage();
        messageToSend.setChatId(chatId);
        messageToSend.setText(message);

        try {
            bot.execute(messageToSend);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}