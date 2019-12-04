package ru.itis;

import lombok.Data;
import org.junit.AfterClass;
import org.junit.Before;

import java.util.List;

@Data
public class TestBase {
    protected static AppManager appManager;
    protected TestDataParser testDataParser;

    @Before
    public void init() {
        appManager = AppManager.getInstance();
        testDataParser = new TestDataParser();
    }

    @AfterClass
    public static void tearDown() {
        appManager.stop();
    }

}
