package ru.itis.testcases;

import org.junit.Test;
import ru.itis.TestBase;
import ru.itis.models.Account;
import ru.itis.models.Answer;

public class AnswersTestCase extends TestBase {

    @Test
    public void editAnswerTestCase() {
        appManager.getLoginHelper().testLogin(Account.builder().login("lesya").password("qwerty").build());
        appManager.getAnswerHelper().editAnswer(new Answer());
        appManager.getLoginHelper().testLogout();
    }
}
