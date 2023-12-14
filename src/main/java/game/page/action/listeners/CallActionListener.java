package game.page.action.listeners;

import game.page.AnswerButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CallActionListener implements ActionListener {

    public static int ANSWERS_COUNT = 4;
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
            int random = (int) (Math.random() * ANSWERS_COUNT);
            while (!buttons.getAnswerButton(random).isEnabled()) {
                random = (int) (Math.random() * ANSWERS_COUNT);
            }

            buttons.getAnswerButton(random).setBackground(Color.GREEN);
            wasClicked = true;
        }

        button.setEnabled(false);
        button.setBackground(null);
    }
}
