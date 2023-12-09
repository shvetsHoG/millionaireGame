package home.page;

import home.page.ActionListeners.ExitActionListener;
import home.page.ActionListeners.StartGameActionListener;

import javax.swing.*;
import java.awt.*;

public class StartPage extends JFrame {

    public static String START_GAME = "Начать игру!";
    public static String QUIT = "Выйти";

    public StartPage() {
        super("Меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel(new FlowLayout());
        JButton startGame = new JButton(START_GAME);
        JButton exitGame = new JButton(QUIT);

        startGame.addActionListener(new StartGameActionListener(this));
        exitGame.addActionListener(new ExitActionListener());

        panel.add(startGame);
        panel.add(exitGame);
        add(panel, BorderLayout.CENTER);
    }
}
