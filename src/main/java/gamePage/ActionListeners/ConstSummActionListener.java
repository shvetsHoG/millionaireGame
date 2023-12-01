package gamePage.ActionListeners;

import gamePage.ProgressBar;
import gamePage.Score;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConstSummActionListener implements ActionListener {
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
        score.setScore(bar.getScore());
        button.setEnabled(false);
        if (bar.getPosition() == 0) {
            constPane.showMessageDialog(null, "Вы установили несгораемую сумму в размере: " + 0);
        } else {
            constPane.showMessageDialog(null, "Вы установили несгораемую сумму в размере: " + bar.getScore());
        }
    }
}
