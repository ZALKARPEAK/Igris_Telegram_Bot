package com.example.igris_english_bot.bot.button.generator;

import com.example.igris_english_bot.bot.button.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class ButtonGeneration {
    public static InlineKeyboardMarkup createInlineKeyboardMarkup(List<Button> buttons) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (Button button : buttons) {
            InlineKeyboardButton inlineButton = new InlineKeyboardButton();
            inlineButton.setText(button.text);
            inlineButton.setCallbackData(button.callbackData);
            row.add(inlineButton);
        }
        keyboard.add(row);


        markup.setKeyboard(keyboard);
        return markup;
    }
}