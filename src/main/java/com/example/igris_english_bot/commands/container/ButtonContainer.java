package com.example.igris_english_bot.commands.container;

import com.example.igris_english_bot.commands.handler.ButtonHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ButtonContainer {
    private final Map<String, ButtonHandler> handlers = new HashMap<>();

    public void registerButton(String callbackData, ButtonHandler handler) {
        handlers.put(callbackData, handler);
    }

    public ButtonHandler getHandler(String callbackData) {
        return handlers.get(callbackData);
    }
}