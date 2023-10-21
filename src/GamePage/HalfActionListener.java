package GamePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalfActionListener implements ActionListener {

    private final JButton button;

    private int getFalseAns(int first) {
        int falseAns = (int) (Math.random() * 4);
        if ((falseAns == first) || (falseAns == buttons.getTrueAnswerPosition())) {
            falseAns = getFalseAns(first);
        }

        return falseAns;
    }

    boolean wasClicked = false;

    AnswerButtons buttons;

    public HalfActionListener(AnswerButtons answerButtons, JButton button) {
        this.buttons = answerButtons;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!wasClicked) {
            int truePos = buttons.getTrueAnswerPosition();
            int firstRandom = getFalseAns(truePos);
            if (firstRandom != truePos) {
                buttons.getAnswerButton(firstRandom).setEnabled(false);
            }

            int secondRandom = getFalseAns(firstRandom);

            System.out.println(secondRandom);

            buttons.getAnswerButton(secondRandom).setEnabled(false);
        }

        wasClicked = true;
        button.setEnabled(false);
    }
}
