package com.example.igris_english_bot.commands;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import com.example.igris_english_bot.commands.handler.ButtonHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class AnswerFirstQuestionButton implements ButtonHandler {
    private static final String CORRECT_ANSWER_MESSAGE = "Не так уж и много, правда?";
    private static final String NEXT_BUTTON_TEXT = "Да";
    private static final String NEXT_BUTTON_CALLBACK_DATA = "Yes";

    @Override
    public void handle(long chatId, TelegramLongPollingBot bot) {
        TelegramMessageHelper.sendMessageWithButton(chatId, CORRECT_ANSWER_MESSAGE, NEXT_BUTTON_TEXT,
                NEXT_BUTTON_CALLBACK_DATA, bot);
    }
}