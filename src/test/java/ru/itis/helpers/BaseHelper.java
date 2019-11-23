package ru.itis.helpers;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import ru.itis.TestBase;

public abstract class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }
}
