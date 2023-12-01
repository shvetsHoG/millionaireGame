package gamePage;

import requests.DatabaseMillionaireGameRequests;

import javax.swing.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RenderPage {

    private Set<Integer> wasTaken = new HashSet<>();

    public RenderPage() {

    }

    public void renderNewQuestions(AnswerButton[] buttons, JLabel questionLabel) {
        int random = (int) (Math.random() * 17);
        while (wasTaken.contains(random) || random == 0 || random == 11 || random == 12) {
            random = (int) (Math.random() * 17);
        }
        wasTaken.add(random);

        DatabaseMillionaireGameRequests databaseMillionaireGameRequests = new DatabaseMillionaireGameRequests();
        String newQuestion = databaseMillionaireGameRequests.getQuestionById(random);
        Map<String, String> newAnswers = databaseMillionaireGameRequests.getAnswersByQuestionId(random);

        questionLabel.setText(newQuestion);
        Set<String> setKeysAnswers = newAnswers.keySet();
        String[] keysAnswers = new String[4];
        keysAnswers = setKeysAnswers.toArray(keysAnswers);

        for (int i = 0; i < 4; i++) {
            buttons[i].getButton().setBackground(null);
            buttons[i].getButton().setEnabled(true);
            buttons[i].getButton().setText(keysAnswers[i]);
            buttons[i].setBooleanValue(newAnswers.get(keysAnswers[i]).equals("t"));
        }
    }
}
