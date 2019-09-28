package sbt

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

public class Bot extends TelegramLongPollingBot {
    private token = '968077945:AAEI4umxR_UvG1NtpLHlwgB50z2yiv4vJuU'
    private botName = 'GroovyTryBot'

    @Override
    void onUpdateReceived(Update update) {
        def message = update.getMessage().getText();
        println("Message recieved: " + message)
        message = "Lol: " + message
        sendTextMsg(update.getMessage().getChatId().toString(), message);
    }

    @Override
    String getBotUsername() {
        return botName
    }

    @Override
    String getBotToken() {
        return token
    }

    public synchronized void sendTextMsg(String chatId, String msg) {
        SendMessage sendMessage = new SendMessage(chatId, msg)
        sendMessage.enableMarkdown(true)
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            println("Exception: " + e.toString());
        }
    }


}