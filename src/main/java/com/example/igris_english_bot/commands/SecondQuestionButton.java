package com.example.igris_english_bot.commands;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import com.example.igris_english_bot.commands.handler.ButtonHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class SecondQuestionButton implements ButtonHandler {
    private static final String[] SECOND_QUESTION_MESSAGES = {
            "Все дело в распространенности слов. Не обязательно выучивать весь словарь, чтобы говорить свободно",
            "80-90% английской речи покрывают одни и те же слова",
            "Здесь мы собрали для вас библиотеку самых распространенных слов в современной английской речи за последний год",
            "И интегрировали особую технику запоминания, благодаря которой, можно легко осваивать новые слова",
            "Неважно, какой у вас уровень знания языка сейчас. Учить будет легко, ведь вас ждет всего по 10 слов в день",
    };
    private static final String SECOND_QUESTION_MESSAGE = "Ну не прекрасно ли, м?";
    private static final String SECOND_QUESTION_BUTTON_TEXT = "oh yeah";
    private static final String SECOND_QUESTION_CALLBACK_DATA = "Yeah";

    @Override
    public void handle(long chatId, TelegramLongPollingBot bot) {
        for (String message : SECOND_QUESTION_MESSAGES) {
            TelegramMessageHelper.sendMessage(chatId, message, bot);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        TelegramMessageHelper.sendMessageWithButton(chatId, SECOND_QUESTION_MESSAGE, SECOND_QUESTION_BUTTON_TEXT,
                SECOND_QUESTION_CALLBACK_DATA, bot);
    }
}
