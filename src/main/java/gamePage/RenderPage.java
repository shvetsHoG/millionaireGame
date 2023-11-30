package gamePage;

import javax.swing.*;
import java.awt.*;

public class RenderPage {

    private int count = 0;

    private ProgressBar bar;

    private JPanel answers = new JPanel(new GridLayout(2, 2));

    private JFrame frame;

    public RenderPage(JFrame frame /*JPanel answers*/, ProgressBar bar) {
        this.frame = frame;
        //this.answers = answers;
        this.bar = bar;
    }

    public AnswerButtons renderNewPage() {

        String qstn = "Кто президент Российской Федерации"; //todo доделать базу вопросов
        String[][] arrayOfAnswers = new String[4][2];
        arrayOfAnswers[0][0] = "Владимир Путин";
        arrayOfAnswers[0][1] = "True";
        arrayOfAnswers[1][0] = "Джо Байден";
        arrayOfAnswers[1][1] = "False";
        arrayOfAnswers[2][0] = "Александр Лукашенко";
        arrayOfAnswers[2][1] = "False";
        arrayOfAnswers[3][0] = "Пётр I";
        arrayOfAnswers[3][1] = "False";

        String[] stringAnswers = new String[4];
        Boolean[] booleanAnswers = new Boolean[4];

        for (int i = 0; i < 4; i++) {
            stringAnswers[i] = arrayOfAnswers[i][0];
            booleanAnswers[i] = Boolean.parseBoolean(arrayOfAnswers[i][1]);
        }

        AnswerButtons answerButtons = new AnswerButtons(stringAnswers, booleanAnswers, bar, this.frame);

        for (int i = 0; i < 4; i++) {
            answerButtons.getAnswerButton(i).setBackground(null);
            answerButtons.getAnswerButton(i).setEnabled(true);
        }

        JPanel newAnswers = new JPanel(new GridLayout(2, 2));

        for (int i = 0; i < 4; i++) {
            newAnswers.add(answerButtons.getAnswerButton(i));
        }

        frame.remove(answers);
        answers = newAnswers;
        frame.add(newAnswers);

        return answerButtons;
    }
}
