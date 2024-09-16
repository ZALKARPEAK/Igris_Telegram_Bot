package com.example.igris_english_bot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public abstract class Command {
    private final String commandName;

    protected Command(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public abstract void execute(long chatId, String data, TelegramLongPollingBot bot);
}