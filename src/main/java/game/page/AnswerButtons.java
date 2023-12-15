package game.page;

import game.page.action.listeners.AnswerButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class AnswerButtons {

    public static int ANSWERS_COUNT = 4;
    private AnswerButton[] box = new AnswerButton[ANSWERS_COUNT];

    public AnswerButtons(Score constSumm, JLabel scoreLabel, RenderPage newPage,
                         JLabel questionLabel, ProgressBar bar, JFrame frame) {
        for (int i = 0; i < box.length; i++) {
            box[i] = new AnswerButton();
            box[i].getButton().addActionListener(new AnswerButtonActionListener(constSumm, scoreLabel,
                    newPage, box[i], bar, frame, box, questionLabel));
        }
    }

    public JButton getAnswerButton(int position) {
        return box[position].getButton();
    }

    public AnswerButton[] getButtonsArray() {
        return box;
    }

    public void setColor(int red, int green, int blue) {
        for (AnswerButton button : box) {
            button.getButton().setBackground(new Color(red, green, blue));
        }
    }

    public void setFont(String name, int style , int size) {
        for (AnswerButton button : box) {
            button.getButton().setFont(new Font(name, style, size));
        }
    }

    public void setFocusable(boolean b) {
        for (AnswerButton button : box) {
            button.getButton().setFocusable(b);
        }
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
