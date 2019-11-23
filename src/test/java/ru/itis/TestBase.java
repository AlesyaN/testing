package ru.itis;

import lombok.Data;
import org.junit.After;
import org.junit.Before;

@Data
public class TestBase {
    protected AppManager appManager;

    @Before
    public void initAppManager() {
        this.appManager = new AppManager();
    }

    @After
    public void tearDown() {
        appManager.stop();
    }



}
