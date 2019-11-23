package ru.itis.testcases;


import org.junit.Test;
import org.testng.Assert;
import ru.itis.TestBase;
import ru.itis.models.Account;
import ru.itis.models.Comment;

public class CommentTestCase extends TestBase {

    @Test
    public void testComment() {
        int commentsNumBefore = appManager.getCommentHelper().getCommentsNum();
        appManager.getLoginHelper().testLogin(new Account("lesya", "qwerty"));
        appManager.getCommentHelper().testAddComment(new Comment());
        appManager.getLoginHelper().testLogout();
        int commentsNumAfter = appManager.getCommentHelper().getCommentsNum();
        Assert.assertEquals(commentsNumAfter, commentsNumBefore + 1);
    }
    
    @Test
    public void testDeleteComment() {
        int commentsNumBefore = appManager.getCommentHelper().getCommentsNum();
        appManager.getLoginHelper().testLogin(new Account("lesya", "qwerty"));
        appManager.getCommentHelper().testDeleteComment();
        appManager.getLoginHelper().testLogout();
        int commentsNumAfter = appManager.getCommentHelper().getCommentsNum();
        Assert.assertEquals(commentsNumAfter, commentsNumBefore - 1);
    }


}
