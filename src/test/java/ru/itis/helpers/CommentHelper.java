package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.AppManager;
import ru.itis.models.Comment;

public class CommentHelper extends BaseHelper{

    public CommentHelper(AppManager appManager) {
        super(appManager);
    }

    public void testAddComment(Comment comment) {
        driver.get("http://localhost:8080/profile");
        driver.findElement(By.id("comments-tab")).click();
        driver.findElement(By.id("commentinput82")).click();
        driver.findElement(By.id("commentinput82")).clear();
        driver.findElement(By.id("commentinput82")).sendKeys(comment.getText());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete question'])[1]/following::button[1]")).click();
        driver.get("http://localhost:8080/logout");
    }

    public void testDeleteComment() {
        driver.get("http://localhost:8080/profile/lesya");
        driver.findElement(By.id("comments-tab")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
    }
}
