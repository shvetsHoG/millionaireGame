package game.page;

import javax.swing.*;

public class AnswerButton extends JButton {

    private boolean booleanValue;

    private JButton button;

    public AnswerButton() {
        this.button = new JButton();
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
