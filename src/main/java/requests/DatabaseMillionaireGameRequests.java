package requests;

import database.DatabaseMillionaireGame;

import java.util.Map;

public class DatabaseMillionaireGameRequests {

    private final DatabaseMillionaireGame db = DatabaseMillionaireGame.getInstance();

    private static final String QUESTIONS_TABLE_NAME = "questions";

    private static final String ANSWER = "answer";

    private static final String ANSWERS_TABLE_NAME = "answers";

    private static final String IS_RIGHT_ANSWER = "isrightanswer";

    private static final String ID = "id";

    private static final String QUESTION = "question";
    private static final String ID_QUESTION = "idquestion";

    public String getQuestionById(int id) {
        String fromDB = db.selectById(
                id,
                QUESTIONS_TABLE_NAME,
                ID,
                QUESTION
        );

        if (fromDB == null && fromDB.isEmpty()) {
            return null;
        }

        return fromDB;
    }

    public Map<String, String> getAnswersByQuestionId(int id) {
        Map<String, String> fromDB = db.selectById(
                id,
                ANSWERS_TABLE_NAME,
                ID_QUESTION,
                ANSWER,
                IS_RIGHT_ANSWER
        );

        if (fromDB == null && fromDB.isEmpty()) {
            return null;
        }

        return fromDB;
    }
}
