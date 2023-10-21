package GamePage;

import javax.swing.*;

public class AnswerButton extends JButton {

    private boolean booleanValue;

    private JButton button = new JButton("");

    public AnswerButton(String text, boolean booleanValue) {
        this.button = new JButton(text);
        this.booleanValue = booleanValue;
    }

    public JButton getButton() {
        return button;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }
}
