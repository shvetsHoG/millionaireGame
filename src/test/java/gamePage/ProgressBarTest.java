package gamePage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class ProgressBarTest {
    @Test
    @DisplayName("getScore test")
    public void getScoreTest(){
        ProgressBar bar = new ProgressBar();

        then(bar.getScore()).isEqualTo(500);
        bar.setPosition(7);
        then(bar.getScore()).isEqualTo(25000);
    }
}
