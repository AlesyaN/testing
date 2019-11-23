package ru.itis.testcases;


import org.junit.Test;
import ru.itis.TestBase;
import ru.itis.models.Account;
import ru.itis.models.Comment;

public class CommentTestCase extends TestBase {

    @Test
    public void testComment() {
        loginHelper.testLogin(new Account("lesya", "qwerty"));
        commentHelper.testAddComment(new Comment());
        loginHelper.testLogout();
    }
    
    @Test
    public void testDeleteComment() {
        loginHelper.testLogin(new Account("lesya", "qwerty"));
        commentHelper.testAddComment(new Comment());
        commentHelper.testDeleteComment();
        loginHelper.testLogout();
    }


}
