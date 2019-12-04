package ru.itis.testcases;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.TestBase;
import ru.itis.models.Account;
import ru.itis.models.Answer;

public class AnswersTestCase extends TestBase {

    @Test
    public void editAnswerTestCase() {
        String lastAnswerBefore = appManager.getAnswerHelper().getLastAnswer();
        appManager.getLoginHelper().testLogin(Account.builder().login("lesya").password("qwerty").build());
        appManager.getAnswerHelper().editAnswer((Answer) testDataParser.get("Answer").get(0));
        appManager.getLoginHelper().testLogout();
        String lastAnswerAfter = appManager.getAnswerHelper().getLastAnswer();
        Assert.assertNotEquals(lastAnswerAfter, lastAnswerBefore);
    }
}
