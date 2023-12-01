package gamePage;

import defaultPage.StartPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class AnswerButtonActionListener implements ActionListener {

    private AnswerButton[] box;

    private final JOptionPane losePane = new JOptionPane();

    private JFrame frame;

    private ProgressBar bar;

    private JLabel questionLabel;

    private AnswerButton button;
    private Set<Integer> wasTaken;
    private RenderPage newPage = new RenderPage();

    public AnswerButtonActionListener(RenderPage newPage, AnswerButton button, ProgressBar bar, JFrame frame, AnswerButton[] box, JLabel questionLabel) {
        this.bar = bar;
        this.frame = frame;
        this.box = box;
        this.questionLabel = questionLabel;
        this.button = button;
        this.newPage = newPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (bar.getPosition() == 14) {
            losePane.showMessageDialog(null, "You win!\n Your score:");
            frame.dispose();
            StartPage startPage = new StartPage();
        } else if (button.getBooleanValue() && bar.getPosition() < 15) {
            bar.switchProgressToNext();
            newPage.renderNewQuestions(box, questionLabel);
        } else {
            bar.switchProgressToLose();
            losePane.showMessageDialog(null, "You lose\n Your score:");
            frame.dispose();
            StartPage startPage = new StartPage();
        }
    }
}
