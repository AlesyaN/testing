package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.AppManager;
import ru.itis.models.Comment;

public class CommentHelper extends BaseHelper{

    public CommentHelper(AppManager appManager) {
        super(appManager);
    }

    public void testAddComment(Comment comment) {
        driver.get(appManager.getBaseUrl() +"/profile");
        driver.findElement(By.id("comments-tab")).click();
        driver.findElement(By.cssSelector("input[id^=commentinput]")).click();
        driver.findElement(By.cssSelector("input[id^=commentinput]")).clear();
        driver.findElement(By.cssSelector("input[id^=commentinput]")).sendKeys(comment.getText());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete question'])[1]/following::button[1]")).click();
        driver.get(appManager.getBaseUrl() + "/logout");
    }

    public void testDeleteComment() {
        driver.get(appManager.getBaseUrl() + "/profile/lesya");
        driver.findElement(By.id("comments-tab")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
    }

    public int getCommentsNum() {
        driver.get(appManager.getBaseUrl() + "/profile/lesya");
        driver.findElement(By.id("comments-tab")).click();
        return driver.findElements(By.cssSelector("div[id^=comment][class=list-group-item\\ flex-column\\ align-items-start]")).size();
    }
}
