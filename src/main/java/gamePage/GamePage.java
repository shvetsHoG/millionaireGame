package gamePage;

import javax.swing.*;
import java.awt.*;

public class GamePage extends  JFrame{

    public GamePage() {
        super("Кто хочет стать миллионером");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JPanel head = new JPanel(new GridLayout(3,4, 2, 2));
        add(head, BorderLayout.NORTH);

        JPanel answers = new JPanel(new GridLayout(2, 2));
        add(answers, BorderLayout.CENTER);

        JPanel progress = new JPanel(new FlowLayout());
        add(progress, BorderLayout.SOUTH);

        JButton backToMenu = new JButton("Вернуться в меню");
        backToMenu.addActionListener(new BackToMenuActionListener(this));
        head.add(backToMenu);

        JLabel questionLabel = new JLabel("Question: ");

        JLabel progressLabel = new JLabel("Прогресс: ");

        progress.add(progressLabel);

        ProgressBar bar = new ProgressBar();
        ProgressCell[] barCells = bar.getProgressBar();

        for (int i = 0; i < barCells.length; i++) {
            progress.add(barCells[i]);
        }

        barCells[0].setBackground(Color.orange);


        String qstn = "Кто президент Российской Федерации";
        String[][] arrayOfAnswers = new String[4][2];
        arrayOfAnswers[0][0] = "Владимир Путин";
        arrayOfAnswers[0][1] = "True";
        arrayOfAnswers[1][0] = "Джо Байден";
        arrayOfAnswers[1][1] = "False";
        arrayOfAnswers[2][0] = "Александр Лукашенко";
        arrayOfAnswers[2][1] = "False";
        arrayOfAnswers[3][0] = "Пётр I";
        arrayOfAnswers[3][1] = "False";

        String[] stringAnswers = new String[4];
        Boolean[] booleanAnswers = new Boolean[4];

        for (int i = 0; i < 4; i++) {
            stringAnswers[i] = arrayOfAnswers[i][0];
            booleanAnswers[i] = Boolean.parseBoolean(arrayOfAnswers[i][1]);
        }

        RenderPage newPage = new RenderPage();

        AnswerButtons answerButtons = new AnswerButtons(newPage, questionLabel, stringAnswers, booleanAnswers, bar, this);

        for (int i = 0; i < 4; i++) {
            answers.add(answerButtons.getAnswerButton(i));
        }

        questionLabel.setText(qstn);

        JButton helpCall = new JButton("Звонок другу");
        helpCall.addActionListener(new CallActionListener(answerButtons, helpCall));

        JButton helpHalf = new JButton("50/50");
        helpHalf.addActionListener(new HalfActionListener(answerButtons, helpHalf));

        JButton helpAudience = new JButton("Помощь зала");
        helpAudience.addActionListener(new AudienceActionListener(answerButtons, helpAudience));

        head.add(helpCall);
        head.add(helpHalf);
        head.add(helpAudience);
        head.add(questionLabel);

        setVisible(true);
    }
}
