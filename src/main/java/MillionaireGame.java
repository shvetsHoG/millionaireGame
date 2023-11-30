import database.DatabaseMillionaireGame;
import defaultPage.StartPage;
import requests.DatabaseMillionaireGameRequests;

public class MillionaireGame {
    public static void main(String[] args) {
        StartPage startPage = new StartPage();
        DatabaseMillionaireGameRequests databaseMillionaireGameRequests = new DatabaseMillionaireGameRequests();
        databaseMillionaireGameRequests.createQuestion("Кто_президент_РФ");
        int id = databaseMillionaireGameRequests.getQuestionId("Кто_президент_РФ");
        databaseMillionaireGameRequests.createAnswer(id, "Путин" , true);
        databaseMillionaireGameRequests.createAnswer(id, "Джо_Байден" , false);
        databaseMillionaireGameRequests.createAnswer(id, "Зеленский" , false);
        databaseMillionaireGameRequests.createAnswer(id, "Обама" , false);
    }
}