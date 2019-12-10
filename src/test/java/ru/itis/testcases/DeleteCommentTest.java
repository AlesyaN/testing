package ru.itis.testcases;

import org.junit.Test;
import org.testng.Assert;
import ru.itis.AuthBase;
import ru.itis.TestBase;
import ru.itis.models.Account;

public class DeleteCommentTest extends AuthBase {
    @Test
    public void testDeleteComment() {
        int commentsNumBefore = appManager.getCommentHelper().getCommentsNum();
        appManager.getCommentHelper().testDeleteComment();
        int commentsNumAfter = appManager.getCommentHelper().getCommentsNum();
        Assert.assertEquals(commentsNumAfter, commentsNumBefore - 1);
    }
}
