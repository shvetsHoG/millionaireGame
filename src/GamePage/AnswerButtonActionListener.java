package GamePage;

import DefaultPage.StartPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerButtonActionListener implements ActionListener {

    private RenderPage page;

    private final JOptionPane losePane = new JOptionPane();

    private JFrame frame;

    private ProgressBar bar;

    private boolean answer;

    public AnswerButtonActionListener(boolean answer, ProgressBar bar, JFrame frame, RenderPage page) {
        this.answer = answer;
        this.bar = bar;
        this.frame = frame;
        this.page = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (bar.getPosition() == 15) {
            System.out.println("You win");
        } else if (answer && bar.getPosition() < 15) {
            bar.switchProgressToNext();
            page.renderNewPage();
        } else {
            System.out.println("You lose");
            bar.switchProgressToLose();
            losePane.showMessageDialog(null, "You lose\n Your score:");
            frame.dispose();
            StartPage startPage = new StartPage();
        }
    }
}
