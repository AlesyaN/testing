package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.AppManager;
import ru.itis.models.Account;

public class LoginHelper extends BaseHelper {

    public LoginHelper(AppManager appManager) {
        super(appManager);
    }

    public void testLogin(Account account) {
        driver.get(appManager.getBaseUrl() + "/logout");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(account.getLogin());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(account.getPassword());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Remember me'])[1]/following::button[1]")).click();
    }

    public void testLogout() {
        driver.get(appManager.getBaseUrl() + "/logout");
    }

}
