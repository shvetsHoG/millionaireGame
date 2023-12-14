package game.page.ActionListeners;

import home.page.StartPage;
import game.page.AnswerButton;
import game.page.ProgressBar;
import game.page.RenderPage;
import game.page.Score;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerButtonActionListener implements ActionListener {

    public static int LAST_GAME_POSITION = 14;
    public static int LAST_BAR_POSITION = 15;

    public static String WIN_PHRASE = "Вы выиграли!\n Ваш счет: ";

    public static String LOSE_PHRASE = "Вы проиграли!\n Ваш счет: ";

    public static String SCORE_PHRASE = "Score: ";

    private AnswerButton[] box;

    private final JOptionPane losePane = new JOptionPane();

    private JFrame frame;

    private ProgressBar bar;

    private JLabel questionLabel;

    private AnswerButton button;

    private RenderPage newPage;

    private JLabel scoreLabel;

    private Score constSumm;

    public AnswerButtonActionListener(Score constSumm, JLabel scoreLabel,
                                      RenderPage newPage, AnswerButton button,
                                      ProgressBar bar, JFrame frame, AnswerButton[] box,
                                      JLabel questionLabel) {
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
        if (bar.getPosition() == LAST_GAME_POSITION) {
            losePane.showMessageDialog(null, WIN_PHRASE + bar.getScore());
            frame.dispose();
            StartPage startPage = new StartPage();
            startPage.setVisible(true);
        } else if (button.getBooleanValue() && bar.getPosition() < LAST_BAR_POSITION) {
            scoreLabel.setText(SCORE_PHRASE + bar.getScore());
            bar.switchProgressToNext();
            newPage.renderNewQuestions(box, questionLabel);
        } else {
            bar.switchProgressToLose();
            if (bar.getPosition() == 0) {
                losePane.showMessageDialog(null, LOSE_PHRASE + 0);
                frame.dispose();
                StartPage startPage = new StartPage();
                startPage.setVisible(true);
            } else {
                losePane.showMessageDialog(null, LOSE_PHRASE + constSumm.getScore());
                frame.dispose();
                StartPage startPage = new StartPage();
                startPage.setVisible(true);
            }

            frame.dispose();
            StartPage startPage = new StartPage();
        }
    }
}
