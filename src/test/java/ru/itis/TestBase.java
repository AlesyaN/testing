package ru.itis;

import lombok.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

@Data
public class TestBase {
    protected static AppManager appManager;

    @Before
    public void initAppManager() {
        appManager = AppManager.getInstance();
    }

    @AfterClass
    public static void tearDown() {
        appManager.stop();
    }



}
