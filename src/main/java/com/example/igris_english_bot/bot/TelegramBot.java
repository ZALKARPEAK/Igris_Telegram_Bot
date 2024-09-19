package com.example.igris_english_bot.bot;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import com.example.igris_english_bot.commands.*;
import com.example.igris_english_bot.commands.container.ButtonContainer;
import com.example.igris_english_bot.commands.handler.ButtonHandler;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    private static final String START_BUTTON_TEXT = "Начать";
    private static final String START_BUTTON_CALLBACK_DATA = "starts";
    private static final String START_MESSAGE = "Привет, это Igris🙂";
    private static final String WRONG_ANSWER_MESSAGE = "Нет, немного меньше😉";
    private final ButtonContainer buttonContainer;
    private final TelegramBotsApi telegramBotsApi;

    public TelegramBot(TelegramBotsApi telegramBotsApi) {
        this.telegramBotsApi = telegramBotsApi;
        this.buttonContainer = new ButtonContainer();
        buttonContainer.registerButton("starts", new StartButton());
        buttonContainer.registerButton("next", new FirstQuestionButton());
        buttonContainer.registerButton("3000", new AnswerFirstQuestionButton());
        buttonContainer.registerButton("Yes", new SecondQuestionButton());
        buttonContainer.registerButton("Yeah", new AnswerSecondQuestionButton());
        buttonContainer.registerButton("beautiful", new MoreInformationTechniquesButton());

        try {
            this.telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Igris_eNGLISH_bot";
    }

    @Override
    public String getBotToken() {
        return "7030874805:AAGuagul61MveOCc5p2rY2tM8BCMES4Gn38";
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            handleTextMessage(update);
        } else if (update.hasCallbackQuery()) {
            processCallbackQuery(update.getCallbackQuery());
        }
    }

    private void handleTextMessage(Update update) {
        long chatId = update.getMessage().getChatId();
        TelegramMessageHelper.sendMessageWithButton(chatId, START_MESSAGE,
                START_BUTTON_TEXT, START_BUTTON_CALLBACK_DATA, this);
    }

    private void processCallbackQuery(CallbackQuery callbackQuery) {
        String callbackData = callbackQuery.getData();
        long chatId = callbackQuery.getMessage().getChatId();
        ButtonHandler handler = buttonContainer.getHandler(callbackData);

        if (callbackData.equals("3000")) {
            handler = buttonContainer.getHandler("3000");
        } else if (callbackData.equals("7000") || callbackData.equals("10000")) {
            TelegramMessageHelper.sendMessage(chatId, WRONG_ANSWER_MESSAGE, this);
        }

        if (handler != null) {
            handler.handle(chatId, this);
        }
    }
}