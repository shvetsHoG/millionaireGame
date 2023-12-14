package game.page;

import requests.DatabaseMillionaireGameRequests;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RenderPage {

    private static final int DEFAULT_RED = 240;

    private static final int DEFAULT_GREEN = 248;

    private static final int DEFAULT_BLUE = 255;
    public static int ANSWERS_COUNT = 4;

    public static int QUESTION_NUMBER = 21;

    public static int FIRST_BROKEN_QUESTION = 11;

    public static int SECOND_BROKEN_QUESTION = 12;

    public static String STRING_TRUE = "t";

    private Set<Integer> wasTaken = new HashSet<>();

    public RenderPage() {

    }

    public void renderNewQuestions(AnswerButton[] buttons, JLabel questionLabel) {
        int random = (int) (Math.random() * QUESTION_NUMBER);
        while (wasTaken.contains(random) || random == 0 || random == FIRST_BROKEN_QUESTION || random == SECOND_BROKEN_QUESTION) {
            random = (int) (Math.random() * QUESTION_NUMBER);
        }
        wasTaken.add(random);

        DatabaseMillionaireGameRequests databaseMillionaireGameRequests = new DatabaseMillionaireGameRequests();
        String newQuestion = databaseMillionaireGameRequests.getQuestionById(random);
        Map<String, String> newAnswers = databaseMillionaireGameRequests.getAnswersByQuestionId(random);

        questionLabel.setText(newQuestion);
        Set<String> setKeysAnswers = newAnswers.keySet();
        String[] keysAnswers = new String[ANSWERS_COUNT];
        keysAnswers = setKeysAnswers.toArray(keysAnswers);

        for (int i = 0; i < 4; i++) {
            buttons[i].getButton().setBackground(new Color(DEFAULT_RED, DEFAULT_GREEN, DEFAULT_BLUE));
            buttons[i].getButton().setEnabled(true);
            buttons[i].getButton().setText(keysAnswers[i]);
            buttons[i].setBooleanValue(newAnswers.get(keysAnswers[i]).equals(STRING_TRUE));
        }
    }
}
