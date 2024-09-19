package com.example.igris_english_bot.commands;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import com.example.igris_english_bot.commands.handler.ButtonHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class FirstQuestionButton implements ButtonHandler {
    private static final String FIRST_QUESTION_MESSAGE = "Как думаете, сколько слов на" +
            " английском достаточно знать, чтобы понимать носителей языка, смотреть Netflix в" +
            " оригинале и чувствовать себя комфортно, проживая заграницей?";
    private static final String[] FIRST_QUESTION_BUTTON_TEXT = {"3000", "7000", "10000"};
    private static final String[] FIRST_QUESTION_CALLBACK_DATA = {"3000", "7000", "7000"};

    @Override
    public void handle(long chatId, TelegramLongPollingBot bot) {
        TelegramMessageHelper.sendMessageWithButtons(chatId, FIRST_QUESTION_MESSAGE, FIRST_QUESTION_BUTTON_TEXT,
                FIRST_QUESTION_CALLBACK_DATA, bot);
    }
}
