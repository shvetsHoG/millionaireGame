package home.page;

import home.page.ActionListeners.ExitActionListener;
import home.page.ActionListeners.StartGameActionListener;

import javax.swing.*;
import java.awt.*;

public class StartPage extends JFrame {

    public static String START_GAME = "Начать игру!";
    public static String QUIT = "Выйти";
    public  static String FONT_BAHNSCHRIFT = "Bahnschrift";
    public static int DEFAULT_SIZE = 18;

    public StartPage() {
        super("Меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        JButton startGame = new JButton(START_GAME);
        JButton exitGame = new JButton(QUIT);

        startGame.addActionListener(new StartGameActionListener(this));
        exitGame.addActionListener(new ExitActionListener());

        startGame.setFocusable(false);
        exitGame.setFocusable(false);
        startGame.setBackground(Color.CYAN);
        exitGame.setBackground(Color.CYAN);
        startGame.setFont(new Font(FONT_BAHNSCHRIFT, Font.ITALIC, DEFAULT_SIZE));
        exitGame.setFont(new Font(FONT_BAHNSCHRIFT, Font.ITALIC, DEFAULT_SIZE));

        panel.add(startGame);
        panel.add(exitGame);
        add(panel, BorderLayout.CENTER);
    }
}
