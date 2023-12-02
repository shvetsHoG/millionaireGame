package gamePage;

import gamePage.ActionListeners.*;

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

    public GamePage() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JPanel head = new JPanel(new GridLayout(3,4, 5, 5));
        add(head, BorderLayout.NORTH);

        JPanel answers = new JPanel(new GridLayout(2, 2));
        add(answers, BorderLayout.CENTER);

        JPanel progress = new JPanel(new FlowLayout());
        add(progress, BorderLayout.SOUTH);

        JButton backToMenu = new JButton(BACK_TO_MENU_PHRASE);
        backToMenu.addActionListener(new BackToMenuActionListener(this));
        head.add(backToMenu);


        int intScore = 0;
        ProgressBar bar = new ProgressBar();
        Score score = new Score(intScore);

        JButton constSumm = new JButton(CONST_SUMM_PHRASE);
        constSumm.addActionListener(new ConstSummActionListener(score, bar, constSumm));

        JLabel questionLabel = new JLabel("Question: ");

        JLabel scoreLabel = new JLabel("Score: " + intScore);

        JLabel progressLabel = new JLabel("Прогресс: ");

        progress.add(progressLabel);

        ProgressCell[] barCells = bar.getProgressBar();

        for (int i = 0; i < barCells.length; i++) {
            progress.add(barCells[i]);
        }

        barCells[0].setBackground(Color.orange);


        String qstn = "Кто президент Российской Федерации";
        String[][] arrayOfAnswers = new String[ANSWERS_COUNT][2];
        arrayOfAnswers[0][0] = "Владимир Путин";
        arrayOfAnswers[0][1] = "True";
        arrayOfAnswers[1][0] = "Джо Байден";
        arrayOfAnswers[1][1] = "False";
        arrayOfAnswers[2][0] = "Александр Лукашенко";
        arrayOfAnswers[2][1] = "False";
        arrayOfAnswers[3][0] = "Пётр I";
        arrayOfAnswers[3][1] = "False";

        String[] stringAnswers = new String[ANSWERS_COUNT];
        Boolean[] booleanAnswers = new Boolean[ANSWERS_COUNT];

        for (int i = 0; i < ANSWERS_COUNT; i++) {
            stringAnswers[i] = arrayOfAnswers[i][0];
            booleanAnswers[i] = Boolean.parseBoolean(arrayOfAnswers[i][1]);
        }

        RenderPage newPage = new RenderPage();
        questionLabel.setText(qstn);
        AnswerButtons answerButtons = new AnswerButtons(score, scoreLabel, newPage, questionLabel, stringAnswers, booleanAnswers, bar, this);
        for (int i = 0; i < ANSWERS_COUNT; i++) {
            answers.add(answerButtons.getAnswerButton(i));
        }
        newPage.renderNewQuestions(answerButtons.getButtonsArray(), questionLabel);


        JButton helpCall = new JButton(CALL_FRIEND);
        helpCall.addActionListener(new CallActionListener(answerButtons, helpCall));

        JButton helpHalf = new JButton(HALF_ON_HALF);
        helpHalf.addActionListener(new HalfActionListener(answerButtons, helpHalf));

        JButton helpAudience = new JButton(CALL_AUDIENCE);
        helpAudience.addActionListener(new AudienceActionListener(answerButtons, helpAudience));

        head.add(helpCall);
        head.add(helpHalf);
        head.add(helpAudience);
        head.add(constSumm);
        head.add(scoreLabel);
        head.add(questionLabel);

        setVisible(true);
    }
}
