package com.example.igris_english_bot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private final Map<String, Command> commandContainer = new HashMap<>();

    public CommandContainer() {
        registerCommand(new StartCommand("start"));
    }

    public void registerCommand(Command command) {
        commandContainer.put(command.getCommandName(), command);
    }

    public void executeCommand(long chatId, String data, TelegramLongPollingBot bot) {
        Command command = commandContainer.get(data);
        if (command != null) {
            command.execute(chatId, data, bot);
        }
    }
}