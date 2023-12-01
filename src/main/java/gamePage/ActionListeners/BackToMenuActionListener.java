package gamePage.ActionListeners;

import defaultPage.StartPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BackToMenuActionListener implements ActionListener {

    private JFrame frame;

    public BackToMenuActionListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        StartPage startPage = new StartPage();
        startPage.setVisible(true);
    }
}
