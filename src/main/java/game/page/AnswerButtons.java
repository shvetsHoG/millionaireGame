package game.page;

import game.page.ActionListeners.AnswerButtonActionListener;

import javax.swing.*;

public class AnswerButtons extends JButton {

    public static int ANSWERS_COUNT = 4;

    private AnswerButton[] box = new AnswerButton[ANSWERS_COUNT];

    public AnswerButtons(Score constSumm, JLabel scoreLabel, RenderPage newPage, JLabel questionLabel,
                         String[] stringAnswers, Boolean[] booleanAnswers, ProgressBar bar, JFrame frame) {
        for (int i = 0; i < box.length; i++) {
            box[i] = new AnswerButton(stringAnswers[i], booleanAnswers[i]);
            box[i].getButton().addActionListener(new AnswerButtonActionListener(constSumm, scoreLabel, newPage, box[i], bar, frame, box, questionLabel));
        }
    }

    public JButton getAnswerButton(int position) {
        return box[position].getButton();
    }

    public AnswerButton[] getButtonsArray() {
        return box;
    }

    public int getTrueAnswerPosition() {
        int trueAns = 0;
        for (int i = 0; i < ANSWERS_COUNT; i++) {
            if (box[i].getBooleanValue()) {
                trueAns = i;
                break;
            }
        }
        return trueAns;
    }
}
