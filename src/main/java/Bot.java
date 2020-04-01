import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        Message message=update.getMessage();

        SendMessage sendMessage= new SendMessage();
        if (message!=null && message.hasText()){
            switch (message.getText()){
                case "/help":
                    try {
                        execute(sendMessage.setText(message.getText() + "how can i help"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/settings":
                    try {
                        execute(sendMessage.setText(message.getText() + "What are we going to customize?"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }

    }

    public String getBotUsername("zoame") {
        return null;
    }

    public String getBotToken() {
        return null;
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

}
