package gamePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CallActionListener implements ActionListener {

    boolean wasClicked = false;

    AnswerButtons buttons;

    private final JButton button;

    public CallActionListener(AnswerButtons answerButtons, JButton button) {
        this.buttons = answerButtons;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!wasClicked) {
            int random = (int) (Math.random() * 4);

            buttons.getAnswerButton(random).setBackground(Color.GREEN);
            wasClicked = true;
        }

        button.setEnabled(false);
    }
}