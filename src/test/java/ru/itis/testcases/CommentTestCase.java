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
        appManager.getLoginHelper().testLogin((Account)testDataParser.get("Account").get(0));
        appManager.getCommentHelper().testAddComment((Comment)testDataParser.get("Comment").get(0));
        appManager.getLoginHelper().testLogout();
        int commentsNumAfter = appManager.getCommentHelper().getCommentsNum();
        Assert.assertEquals(commentsNumAfter, commentsNumBefore + 1);
    }
    
    @Test
    public void testDeleteComment() {
        int commentsNumBefore = appManager.getCommentHelper().getCommentsNum();
        appManager.getLoginHelper().testLogin((Account)testDataParser.get("Account").get(0));
        appManager.getCommentHelper().testDeleteComment();
        int commentsNumAfter = appManager.getCommentHelper().getCommentsNum();
        appManager.getLoginHelper().testLogout();
        Assert.assertEquals(commentsNumAfter, commentsNumBefore - 1);
    }


}
