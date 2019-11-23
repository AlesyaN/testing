package ru.itis.helpers;

import org.openqa.selenium.WebDriver;
import ru.itis.AppManager;

public abstract class BaseHelper {
    WebDriver driver;
    AppManager appManager;

    public BaseHelper(AppManager appManager) {
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }
}
