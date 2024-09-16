package com.example.igris_english_bot.util.botUtil;

import java.rmi.AccessException;
import java.util.regex.Pattern;
import static com.example.igris_english_bot.util.botUtil.PropertiesUtil.get;

public final class BotUtil {
    private BotUtil() throws AccessException {
        throw new AccessException("Constructor can't be created");
    }

    public static int DAY_MILLISECONDS = 86400000;

    public static int EXECUTE_NOTICE_TIMEOUT = 600000;

    public static String BOT_TOKEN = get("bot.token");

    public static String BOT_USERNAME = get("bot.username");

    public static String ADMIN_CHAT_ID = get("admin.chat.id");

    public static final int SIZE = Integer.parseInt(get("size"));

    public static final String UNKNOWN_COMMAND_MESSAGE = "Неизвестная команда. Попробуйте /start";

    public static final Pattern JS_PATTERN = Pattern.compile("(\\s|(\\p{P}\\s)?)(?i)(java script)((\\p{P}|\\s)?)");

    public static String keywordPattern(String keyword) {
        return String.format("(\\s|(\\p{P}\\s)?)(?i)(%s)((\\p{P}|\\s)?)", keyword);
    }
}