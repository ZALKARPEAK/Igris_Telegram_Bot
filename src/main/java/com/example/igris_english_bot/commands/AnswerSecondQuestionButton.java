package com.example.igris_english_bot.commands;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import com.example.igris_english_bot.commands.handler.ButtonHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class AnswerSecondQuestionButton implements ButtonHandler {
    private static final String[] ANSWER_MESSAGE = {"Кстати, насчет слов, которые здесь вам предстоит запомнить, сейчас расскажем откуда они",
    "Дело в том, что списки популярных слов каждый год собирают различные уважаемые словари: Oxford, Macmillan и Longmann",
    "На основе их данных состоит наша библиотека",
    "Ну и теперь, осталось дело за малым – все выучить😁",
    "Вместе мы все разложим по полочкам!"};
    private static final String NEXT_BUTTON_MESSAGE = "Сейчас поделимся, как!";
    private static final String NEXT_BUTTON_TEXT = "это прекрасно";
    private static final String NEXT_BUTTON_CALLBACK_DATA = "beautiful";

    @Override
    public void handle(long chatId, TelegramLongPollingBot bot) {
        for (String message : ANSWER_MESSAGE) {
            TelegramMessageHelper.sendMessage(chatId, message, bot);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        TelegramMessageHelper.sendMessageWithButton(chatId, NEXT_BUTTON_MESSAGE, NEXT_BUTTON_TEXT,
                NEXT_BUTTON_CALLBACK_DATA, bot);
    }
}
