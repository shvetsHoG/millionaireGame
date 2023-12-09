package game.page;

import javax.swing.*;

public class ProgressCell extends JButton {

    private final int number;

    public ProgressCell(int number) {
        this.number = number;
        setText(String.valueOf(number));
        setEnabled(false);
    }
}
