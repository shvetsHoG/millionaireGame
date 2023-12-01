package gamePage.ActionListeners;

import defaultPage.StartPage;
import gamePage.AnswerButton;
import gamePage.ProgressBar;
import gamePage.RenderPage;
import gamePage.Score;

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
    private JLabel scoreLabel;
    private Score constSumm;

    public AnswerButtonActionListener(Score constSumm , JLabel scoreLabel, RenderPage newPage, AnswerButton button, ProgressBar bar, JFrame frame, AnswerButton[] box, JLabel questionLabel) {
        this.bar = bar;
        this.frame = frame;
        this.box = box;
        this.questionLabel = questionLabel;
        this.button = button;
        this.newPage = newPage;
        this.scoreLabel = scoreLabel;
        this.constSumm = constSumm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (bar.getPosition() == 14) {
            losePane.showMessageDialog(null, "Вы выиграли!\n Ваш счет: " + bar.getScore());
            frame.dispose();
            StartPage startPage = new StartPage();
        } else if (button.getBooleanValue() && bar.getPosition() < 15) {
            scoreLabel.setText("Score: " + bar.getScore());
            bar.switchProgressToNext();
            newPage.renderNewQuestions(box, questionLabel);
        } else {
            bar.switchProgressToLose();
            if (bar.getPosition() == 0) {
                losePane.showMessageDialog(null, "Вы проиграли\n Ваш счет: " + 0);
            } else {
                System.out.println(constSumm.getScore());
                losePane.showMessageDialog(null, "Вы проиграли\n Ваш счет: " + constSumm.getScore());
            }

            frame.dispose();
            StartPage startPage = new StartPage();
        }
    }
}
