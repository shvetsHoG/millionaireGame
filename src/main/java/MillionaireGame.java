import home.Page.StartPage;
import requests.DatabaseMillionaireGameRequests;

public class MillionaireGame {
    public static void main(String[] args) {
        StartPage startPage = new StartPage();
        startPage.setVisible(true);

        DatabaseMillionaireGameRequests databaseMillionaireGameRequests = new DatabaseMillionaireGameRequests();
        /*databaseMillionaireGameRequests.insertQuestion("К кому первому обратились за помощью дед и бабка, не справившись с репкой");
        databaseMillionaireGameRequests.insertAnswer(21,"К Жучке" , false);
        databaseMillionaireGameRequests.insertAnswer(21,"К дочке" , false);
        databaseMillionaireGameRequests.insertAnswer(21,"к залу" , false);
        databaseMillionaireGameRequests.insertAnswer(21,"К внучке" , true);*/
    }
}