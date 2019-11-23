package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.AppManager;
import ru.itis.models.Account;
import ru.itis.models.Answer;

public class AnswerHelper extends BaseHelper {

    public AnswerHelper(AppManager appManager) {
        super(appManager);
    }


    public void editAnswer(Answer newAnswer) {
        driver.get("http://localhost:8080/profile/lesya");
        driver.findElement(By.id("edit-tab")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[3]/div/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[3]/div/div/input")).sendKeys(newAnswer.getText());
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[3]/div/div/div/button")).click();
    }

    public String getLastAnswer() {
        driver.get("http://localhost:8080/profile/lesya");
        return driver.findElement(By.cssSelector("p[id^=answer]")).getText();
    }
}
