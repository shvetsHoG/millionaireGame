package gamePage;

import java.awt.*;

public class ProgressBar {
    private final ProgressCell[] progress = new ProgressCell[15];
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public ProgressCell[] getProgressBar() {
        for (int i = 0; i < progress.length; i ++) {
            ProgressCell cell = new ProgressCell(i+1);
            progress[i] = cell;
        }

        return progress;
    }

    public void switchProgressToNext() {

        if (position < 14) {
            progress[position].setBackground(Color.GREEN);
            progress[position + 1].setBackground(Color.ORANGE);
            position++;
        } else {
            progress[position].setBackground(Color.GREEN);
            position++;
        }
    }

    public void switchProgressToLose() {
        progress[position].setBackground(Color.RED);
    }
}
