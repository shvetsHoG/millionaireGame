package gamePage;

import defaultPage.StartPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerButtonActionListener implements ActionListener {

    private RenderPage page;

    private final JOptionPane losePane = new JOptionPane();

    private JFrame frame;

    private ProgressBar bar;

    private boolean answer;

    public AnswerButtonActionListener(boolean answer, ProgressBar bar, JFrame frame /*RenderPage page*/) {
        this.answer = answer;
        this.bar = bar;
        this.frame = frame;
        //this.page = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (bar.getPosition() == 14) {
            losePane.showMessageDialog(null, "You win!\n Your score:");
            frame.dispose();
            StartPage startPage = new StartPage();
        } else if (answer && bar.getPosition() < 15) {
            bar.switchProgressToNext();
            RenderPage newPage = new RenderPage(frame, bar);
            newPage.renderNewPage();
        } else {
            bar.switchProgressToLose();
            losePane.showMessageDialog(null, "You lose\n Your score:");
            frame.dispose();
            StartPage startPage = new StartPage();
        }
    }
}
