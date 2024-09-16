package com.example.igris_english_bot.bot;

import com.example.igris_english_bot.commands.CommandContainer;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.example.igris_english_bot.bot.button.message.TelegramMessageHelper.sendMessageWithButton;
import static com.example.igris_english_bot.bot.button.message.TelegramMessageHelper.sendMessageWithButtons;
import static com.example.igris_english_bot.util.botUtil.BotUtil.UNKNOWN_COMMAND_MESSAGE;

@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Component
public class TelegramBot extends TelegramLongPollingBot {
    private static final String NEXT_BUTTON_TEXT = "Далее";
    private static final String NEXT_BUTTON_CALLBACK_DATA = "next";
    private static final String START_MESSAGE = "Привет, это Igris🙂";
    private static final String[] WELCOME_MESSAGES = {
            "Здесь вы сможете улучшить свой словарный запас и выйти на новый уровень общения на английском",
            "Все что от вас требуется – 10 минут в день"};

    private static final String FIRST_QUESTION_BUTTON_TEXT = "Как думаете, сколько слов на английском достаточно знать, чтобы понимать носителей языка, смотреть Netflix в оригинале и чувствовать себя комфортно, проживая заграницей?";

    private final CommandContainer commandContainer;

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
            handleCallbackQuery(update);
        }
    }

    private void handleTextMessage(Update update) {
        String messageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();

        if (messageText.equalsIgnoreCase("/start")) {
            commandContainer.executeCommand(chatId, "start", this);
        } else {
            sendMessage(chatId, UNKNOWN_COMMAND_MESSAGE);
        }
    }

    private void handleCallbackQuery(Update update) {
        String data = update.getCallbackQuery().getData();
        long chatId = update.getCallbackQuery().getMessage().getChatId();

        if (data.equals("starts")) {
            sendWelcomeMessages(chatId);
            sendMessageWithButton(chatId, "Woo-hoo! Запускаем процесс",
                    NEXT_BUTTON_TEXT, NEXT_BUTTON_CALLBACK_DATA, this);
        } else if (data.equals(NEXT_BUTTON_CALLBACK_DATA)) {
            sendMessageWithButtons(chatId, FIRST_QUESTION_BUTTON_TEXT,
                    new String[]{"3000",
                            "7000",
                            "10000"},
                    new String[]{"3000", "7000", "10000"},
                    this);
        }
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
    private void sendWelcomeMessages(long chatId) {
        for (String message : WELCOME_MESSAGES) {
            sendMessage(chatId, message);
        }
    }
}