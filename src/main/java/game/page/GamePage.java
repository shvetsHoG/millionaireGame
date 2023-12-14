package game.page;

import game.page.action.listeners.*;

import javax.swing.*;
import java.awt.*;

public class GamePage extends  JFrame{

    public static int ANSWERS_COUNT = 4;

    public static String CALL_FRIEND = "Звонок другу";

    public static String HALF_ON_HALF = "50/50";

    public static String CALL_AUDIENCE = "Помощь зала";

    public static String CONST_SUMM_PHRASE = "Установить несгораемую сумму";

    public static String BACK_TO_MENU_PHRASE = "Вернуться в меню";

    public static String TITLE = "Кто хочет стать миллионером";

    public  static String FONT_BAHNSCHRIFT = "Bahnschrift";

    public static int DEFAULT_SIZE = 18;

    public static int BIG_SIZE = 20;

    public static int BUTTON_TEXT_SIZE = 24;

    public GamePage() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1900, 800);
        setLocationRelativeTo(null);

        JPanel head = new JPanel();
        head.setLayout(new BoxLayout(head, BoxLayout.Y_AXIS));
        add(head, BorderLayout.NORTH);

        JPanel answers = new JPanel(new GridLayout(2, 2));
        add(answers, BorderLayout.CENTER);

        JPanel progress = new JPanel(new FlowLayout());
        add(progress, BorderLayout.SOUTH);

        JButton backToMenu = new JButton(BACK_TO_MENU_PHRASE);
        backToMenu.addActionListener(new BackToMenuActionListener(this));

        int intScore = 0;
        ProgressBar bar = new ProgressBar();
        Score score = new Score(intScore);

        JButton constSumm = new JButton(CONST_SUMM_PHRASE);
        constSumm.addActionListener(new ConstSummActionListener(score, bar, constSumm));

        JLabel questionLabel = new JLabel("Вопрос: ");
        questionLabel.setFont(new Font(FONT_BAHNSCHRIFT, Font.BOLD, BIG_SIZE));

        JLabel scoreLabel = new JLabel("Счёт: " + intScore);
        scoreLabel.setFont(new Font(FONT_BAHNSCHRIFT, Font.BOLD,DEFAULT_SIZE));

        JLabel progressLabel = new JLabel("Прогресс: ");
        progressLabel.setFont(new Font(FONT_BAHNSCHRIFT, Font.BOLD,DEFAULT_SIZE));

        progress.add(progressLabel);

        ProgressCell[] barCells = bar.getProgressBar();

        for (int i = 0; i < barCells.length; i++) {
            progress.add(barCells[i]);
        }

        barCells[0].setBackground(Color.orange);

        RenderPage newPage = new RenderPage();
        AnswerButtons answerButtons = new AnswerButtons(score, scoreLabel, newPage, questionLabel,
                bar, this);
        for (int i = 0; i < ANSWERS_COUNT; i++) {
            answers.add(answerButtons.getAnswerButton(i));
        }

        newPage.renderNewQuestions(answerButtons.getButtonsArray(), questionLabel);

        answerButtons.setColor(240, 248, 255);
        answerButtons.setFont(FONT_BAHNSCHRIFT, Font.BOLD, BUTTON_TEXT_SIZE);
        answerButtons.setFocusable(false);

        JButton helpCall = new JButton(CALL_FRIEND);
        helpCall.addActionListener(new CallActionListener(answerButtons, helpCall));

        JButton helpHalf = new JButton(HALF_ON_HALF);
        helpHalf.addActionListener(new HalfActionListener(answerButtons, helpHalf));

        JButton helpAudience = new JButton(CALL_AUDIENCE);
        helpAudience.addActionListener(new AudienceActionListener(answerButtons, helpAudience));

        JPanel helpButtons = new JPanel(new GridLayout(2, 3, 2, 2));
        JPanel questionPanel = new JPanel(new FlowLayout());

        backToMenu.setFocusable(false);
        helpAudience.setFocusable(false);
        helpHalf.setFocusable(false);
        helpCall.setFocusable(false);
        constSumm.setFocusable(false);

        backToMenu.setBackground(new Color(255, 218, 185));
        helpAudience.setBackground(new Color(176, 224, 230));
        helpHalf.setBackground(new Color(176, 224, 230));
        helpCall.setBackground(new Color(176, 224, 230));
        constSumm.setBackground(new Color(216, 191, 216));

        backToMenu.setFont(new Font(FONT_BAHNSCHRIFT, Font.ITALIC, DEFAULT_SIZE));
        helpAudience.setFont(new Font(FONT_BAHNSCHRIFT, Font.ITALIC, DEFAULT_SIZE));
        helpCall.setFont(new Font(FONT_BAHNSCHRIFT, Font.ITALIC, DEFAULT_SIZE));
        helpHalf.setFont(new Font(FONT_BAHNSCHRIFT, Font.ITALIC, DEFAULT_SIZE));
        constSumm.setFont(new Font(FONT_BAHNSCHRIFT, Font.ITALIC, DEFAULT_SIZE));

        helpButtons.add(backToMenu);
        helpButtons.add(helpCall);
        helpButtons.add(helpHalf);
        helpButtons.add(helpAudience);
        helpButtons.add(constSumm);
        helpButtons.add(scoreLabel);
        questionPanel.add(questionLabel);

        head.add(helpButtons);
        head.add(questionPanel);

        setVisible(true);
    }
}
