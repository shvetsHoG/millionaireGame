package game.page.action.listeners;

import game.page.ProgressBar;
import game.page.Score;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConstSummActionListener implements ActionListener {

    public static String CONST_SUMM_PHRASE = "Вы установили несгораемую сумму в размере: ";
    private Score score;

    private ProgressBar bar;

    private JButton button;

    private final JOptionPane constPane = new JOptionPane();
    public ConstSummActionListener(Score score, ProgressBar bar, JButton button) {
        this.score = score;
        this.bar = bar;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        score.setScore(bar.getConstSummScore());
        button.setEnabled(false);
        button.setBackground(null);
        if (bar.getPosition() == 0) {
            constPane.showMessageDialog(null, CONST_SUMM_PHRASE + 0);
        } else {
            constPane.showMessageDialog(null, CONST_SUMM_PHRASE + bar.getConstSummScore());
        }
    }
}
