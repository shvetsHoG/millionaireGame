package gamePage;

import javax.swing.*;
import java.awt.*;

public class GamePage extends  JFrame{

    public GamePage() {
        super("Who wants to be a millionaire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JPanel head = new JPanel(new GridLayout(3,4, 2, 2));
        add(head, BorderLayout.NORTH);

        JPanel answers = new JPanel(new GridLayout(2, 2));
        add(answers, BorderLayout.CENTER);

        JPanel progress = new JPanel(new FlowLayout());
        add(progress, BorderLayout.SOUTH);

        JButton backToMenu = new JButton("Back to Menu");
        backToMenu.addActionListener(new BackToMenuActionListener(this));
        head.add(backToMenu);

        JLabel questionLabel = new JLabel("domain.Question: ");

        JLabel progressLabel = new JLabel("Progress: ");

        progress.add(progressLabel);

        ProgressBar bar = new ProgressBar();
        ProgressCell[] barCells = bar.getProgressBar();

        for (int i = 0; i < barCells.length; i++) {
            progress.add(barCells[i]);
        }

        barCells[0].setBackground(Color.orange);

        RenderPage page = new RenderPage(this, bar);

        String qstn = "Кто президент Российской Федерации"; //todo доделать базу вопросов
        /*String[][] arrayOfAnswers = new String[4][2];
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
        }*/

        AnswerButtons answerButtons = page.renderNewPage();

        /*for (int i = 0; i < 4; i++) {
            answers.add(answerButtons.getAnswerButton(i));
        }*/

        questionLabel.setText("domain.Question: " + qstn);

        JButton helpCall = new JButton("Call a friend");
        helpCall.addActionListener(new CallActionListener(answerButtons, helpCall));

        JButton helpHalf = new JButton("50/50");
        helpHalf.addActionListener(new HalfActionListener(answerButtons, helpHalf));

        JButton helpAudience = new JButton("Help from the audience");
        helpAudience.addActionListener(new AudienceActionListener(answerButtons, helpAudience));

        head.add(helpCall);
        head.add(helpHalf);
        head.add(helpAudience);
        head.add(questionLabel);

        setVisible(true);
    }
}
