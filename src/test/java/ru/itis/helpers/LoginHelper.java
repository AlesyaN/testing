package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.models.Account;

public class LoginHelper extends BaseHelper {

    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void testLogin(Account account) {
        driver.get("http://localhost:8080/logout");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(account.getLogin());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(account.getPassword());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Remember me'])[1]/following::button[1]")).click();
    }

    public void testLogout() {
        driver.get("http://localhost:8080/logout");
    }

}
