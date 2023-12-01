package gamePage;

import javax.swing.*;

public class AnswerButtons extends JButton {

    private AnswerButton[] box = new AnswerButton[4];

    public AnswerButtons(RenderPage newPage, JLabel questionLabel, String[] stringAnswers, Boolean[] booleanAnswers, ProgressBar bar, JFrame frame) {
        for (int i = 0; i < box.length; i++) {
            box[i] = new AnswerButton(stringAnswers[i], booleanAnswers[i]);
            box[i].getButton().addActionListener(new AnswerButtonActionListener(newPage, box[i], bar, frame, box, questionLabel));
        }
    }

    public JButton getAnswerButton(int position) {
        return box[position].getButton();
    }

    public int getTrueAnswerPosition() {
        int trueAns = 0;
        for (int i = 0; i < 4; i++) {
            if (box[i].getBooleanValue()) {
                trueAns = i;
                break;
            }
        }
        return trueAns;
    }
}
