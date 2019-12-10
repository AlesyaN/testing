package ru.itis.testcases;


import org.junit.Test;
import org.testng.Assert;
import ru.itis.AuthBase;
import ru.itis.models.Comment;

public class AddCommentTest extends AuthBase {

    @Test
    public void testComment() {
        int commentsNumBefore = appManager.getCommentHelper().getCommentsNum();
        appManager.getCommentHelper().testAddComment((Comment)testDataParser.get("Comment").get(0));
        int commentsNumAfter = appManager.getCommentHelper().getCommentsNum();
        Assert.assertEquals(commentsNumAfter, commentsNumBefore + 1);
    }
    



}
