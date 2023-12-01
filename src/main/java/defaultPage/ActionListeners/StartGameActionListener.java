package defaultPage.ActionListeners;

import gamePage.GamePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGameActionListener implements ActionListener {
    private JFrame frame;
    public StartGameActionListener(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        GamePage field = new GamePage();
    }
}
