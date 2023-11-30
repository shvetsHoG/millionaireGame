package defaultPage;

import javax.swing.*;
import java.awt.*;

public class StartPage extends  JFrame{
    public StartPage() {
        super("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel(new FlowLayout());
        JButton startGame = new JButton("Start game!");
        JButton exitGame = new JButton("Exit");

        startGame.addActionListener(new StartGameActionListener(this));
        exitGame.addActionListener(new ExitActionListener());

        panel.add(startGame);
        panel.add(exitGame);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}
