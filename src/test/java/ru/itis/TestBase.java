package ru.itis;

import lombok.Data;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.itis.helpers.AccountHelper;
import ru.itis.helpers.BaseHelper;
import ru.itis.helpers.CommentHelper;
import ru.itis.helpers.LoginHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@Data
public class TestBase {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    protected AccountHelper accountHelper;
    protected CommentHelper commentHelper;
    protected LoginHelper loginHelper;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Uni\\Testing\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        accountHelper = new AccountHelper(driver);
        commentHelper = new CommentHelper(driver);
        loginHelper = new LoginHelper(driver);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }



}
