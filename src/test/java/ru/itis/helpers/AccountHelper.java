package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.TestBase;

public class AccountHelper extends BaseHelper {


    public AccountHelper(WebDriver driver) {
        super(driver);
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
