package com.example.igris_english_bot.commands;

import com.example.igris_english_bot.bot.button.message.TelegramMessageHelper;
import com.example.igris_english_bot.commands.handler.ButtonHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class LearnOrDoButtonsButton implements ButtonHandler {
    private static final String[] LEARN_OR_DO_MESSAGES = {"Смотрите, каждый день вы будете учить всего лишь по 10 новых слов, а потом через определенный промежуток времени, важный для закрепления слов в памяти, повторять их",
    "Таким образом, к примеру уже за 3 месяца, вы будете знать почти 1000 новых слов!",
    "Если хотите узнать секрет, как работает ваша память, разобраться во всех вопросах, то выберете кнопку [узнать секрет]"};
    private static final String LEARN_OR_DO_BUTTON_MESSAGE = "Ну, а если горите сразу приступить к делу - смело выбирайте [сразу к делу]";
    private static final String[] LEARN_OR_DO_BUTTON_TEXT = {"узнать секрет", "сразу к делу"};
    private static final String[] LEARN_OR_DO_CALLBACK_DATA = {"find out the secret", "straight to the point"};

    @Override
    public void handle(long chatId, TelegramLongPollingBot bot) {
        for (String message : LEARN_OR_DO_MESSAGES) {
            TelegramMessageHelper.sendMessage(chatId, message, bot);
        }
    }
}