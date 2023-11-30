package domain;

public class Question {
    private int id;

    private String question;

    private String answer;

    private boolean isRightAnswer;

    public Question(int id, String question, String answer, boolean isRightAnswer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.isRightAnswer = isRightAnswer;
    }

    public int getId() {
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public boolean isRightAnswer() {
        return isRightAnswer;
    }
}
