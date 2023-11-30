package requests;

import database.DatabaseMillionaireGame;
import domain.Question;
import java.util.Map;

public class DatabaseMillionaireGameRequests {

    private final DatabaseMillionaireGame db = DatabaseMillionaireGame.getInstance();

    private static final String TABLE_NAME = "questions";

    private static final String ID = "id";

    private static final String QUESTION = "question";

    private static final String ANSWER = "answer";
    private static final String IS_RIGHT_ANSWER = "isRightAnswer";

    public void createQuestion(String question) {
        String sql = """
                insert into millionaire.questions
                (question)
                values
                ('%s')
                """;
        db.execute(String.format(sql, question));
    }

    public void createAnswer(int idQuestion, String answer, boolean isRightAnswer) {
        String sql = """
                insert into millionaire.answers
                (idQuestion, answer, isRightAnswer)
                values
                (%d, '%s', %b)
                """;
        db.execute(String.format(sql, idQuestion, answer, isRightAnswer));
    }

    public int getQuestionId(String question) {
        return Integer.parseInt(db.selectQuestionId(question));
    }

    public Question getQuestionById(int id) {
        Map<String, String> fromDB = db.selectById(
                id,
                TABLE_NAME,
                ID,
                QUESTION,
                ANSWER,
                IS_RIGHT_ANSWER
        );

        if (fromDB == null && fromDB.isEmpty()) {
            return null;
        }

        return convertQuestion(fromDB);
    }

    protected Question convertQuestion(Map<String, String> fromDB) {
        return new Question(
                Integer.parseInt(String.valueOf(fromDB.get(ID))),
                fromDB.get(QUESTION),
                fromDB.get(ANSWER),
                Boolean.parseBoolean(fromDB.get(IS_RIGHT_ANSWER))
        );
    }

}
