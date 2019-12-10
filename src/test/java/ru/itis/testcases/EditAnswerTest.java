package ru.itis.testcases;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.AuthBase;
import ru.itis.TestBase;
import ru.itis.models.Account;
import ru.itis.models.Answer;

public class EditAnswerTest extends AuthBase {

    @Test
    public void editAnswerTestCase() {
        String lastAnswerBefore = appManager.getAnswerHelper().getLastAnswer();
        appManager.getAnswerHelper().editAnswer((Answer) testDataParser.get("Answer").get(0));
        String lastAnswerAfter = appManager.getAnswerHelper().getLastAnswer();
        Assert.assertNotEquals(lastAnswerAfter, lastAnswerBefore);
    }
}
