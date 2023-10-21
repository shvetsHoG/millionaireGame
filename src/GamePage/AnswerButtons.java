package GamePage;

import javax.swing.*;

public class AnswerButtons extends JButton {

    private AnswerButton[] box = new AnswerButton[4];

    public AnswerButtons(String[] stringAnswers, Boolean[] booleanAnswers, ProgressBar bar, JFrame frame, RenderPage page) {
        for (int i = 0; i < box.length; i++) {
            box[i] = new AnswerButton(stringAnswers[i], booleanAnswers[i]);
            box[i].getButton().addActionListener(new AnswerButtonActionListener(box[i].getBooleanValue(), bar, frame, page));
        }
    }

    public AnswerButtons(AnswerButton[] buttons) {
        this.box = buttons;
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
