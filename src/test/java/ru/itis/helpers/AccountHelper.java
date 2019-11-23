package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.AppManager;

public class AccountHelper extends BaseHelper {


    public AccountHelper(AppManager appManager) {
        super(appManager);
    }

    public void testEditPageTestCase() {
        driver.get("http://localhost:8080/profile");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Followers'])[1]/following::button[1]")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Beijing");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Avatar'])[1]/following::button[1]")).click();
        driver.get("http://localhost:8080/logout");
    }
}
