package ru.itis;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.itis.helpers.AccountHelper;
import ru.itis.helpers.CommentHelper;
import ru.itis.helpers.LoginHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@Data
public class AppManager {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    protected AccountHelper accountHelper;
    protected CommentHelper commentHelper;
    protected LoginHelper loginHelper;


    public AppManager() {
        System.setProperty("webdriver.gecko.driver", "C:\\Uni\\Testing\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        accountHelper = new AccountHelper(this);
        commentHelper = new CommentHelper(this);
        loginHelper = new LoginHelper(this);
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}