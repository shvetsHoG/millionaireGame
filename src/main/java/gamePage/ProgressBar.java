package gamePage;

import java.awt.*;

public class ProgressBar {
    private final ProgressCell[] progress = new ProgressCell[15];
    private int position = 0;
    private int[] scoreVars = new int[]{
            500, 1000, 2000, 3000, 5000,
            10000, 15000, 25000, 50000, 100000,
            200000, 400000, 800000, 1500000, 3000000};

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getScore() {
        return scoreVars[this.getPosition()];
    }

    public int getConstSummScore() {
        if (this.getPosition() == 0) {
            return 0;
        } else {
            return scoreVars[this.getPosition() - 1];
        }
    }

    public ProgressCell[] getProgressBar() {
        for (int i = 0; i < progress.length; i++) {
            ProgressCell cell = new ProgressCell(i + 1);
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
