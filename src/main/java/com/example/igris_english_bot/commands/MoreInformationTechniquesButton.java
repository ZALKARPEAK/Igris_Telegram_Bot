package com.example.igris_english_bot.commands;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import com.example.igris_english_bot.commands.handler.ButtonHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class MoreInformationTechniquesButton implements ButtonHandler {
    private static final String MORE_INFORMATION_TECHNIQUES_MESSAGE = "Все просто – фишка в техниках запоминания";
    private static final String MORE_INFORMATION_TECHNIQUES_BUTTON_MESSAGE = "Это легкие механики, которые помогут отложить слово в долговременную память";
    private static final String MORE_INFORMATION_TECHNIQUES_BUTTON_TEXT = "можно поподробнее";
    private static final String MORE_INFORMATION_TECHNIQUES_CALLBACK_DATA = "MoreInformationOnTechniques";

    @Override
    public void handle(long chatId, TelegramLongPollingBot bot) {
        TelegramMessageHelper.sendMessage(chatId, MORE_INFORMATION_TECHNIQUES_MESSAGE, bot);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TelegramMessageHelper.sendMessageWithButton(chatId, MORE_INFORMATION_TECHNIQUES_BUTTON_MESSAGE,
                MORE_INFORMATION_TECHNIQUES_BUTTON_TEXT, MORE_INFORMATION_TECHNIQUES_CALLBACK_DATA,
                bot);
    }
}
