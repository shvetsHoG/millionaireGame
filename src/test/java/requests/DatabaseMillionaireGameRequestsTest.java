package requests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.BDDAssertions.then;

public class DatabaseMillionaireGameRequestsTest {
    @Test
    @DisplayName("getAnswersByQuestionId request test")
    public void getAnswersByQuestionIdRequestTest(){
        DatabaseMillionaireGameRequests databaseMillionaireGameRequests = new DatabaseMillionaireGameRequests();
        Map<String, String> map = databaseMillionaireGameRequests.getAnswersByQuestionId(1);
        Set<String> set = map.keySet();
        String[] keysAnswers = new String[4];
        keysAnswers = set.toArray(keysAnswers);
        Arrays.stream(keysAnswers).sorted(String::compareTo);

        then(keysAnswers[0]).isEqualTo("Даосизм");
        then(keysAnswers[1]).isEqualTo("Буддизм");
        then(keysAnswers[2]).isEqualTo("Иудаизм");
        then(keysAnswers[3]).isEqualTo("Индуизм");
    }
}
