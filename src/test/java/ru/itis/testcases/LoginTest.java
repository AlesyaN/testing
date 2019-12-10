package ru.itis.testcases;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.TestBase;
import ru.itis.models.Account;

public class LoginTest extends TestBase {

    @Test
    public void loginWithValidCredentials() {
        appManager.getLoginHelper().login((Account)testDataParser.get("Account").get(0));
        Assert.assertTrue(appManager.getLoginHelper().isLoggedIn());
    }

    @Test
    public void loginWithInvalidCredentials() {
        appManager.getLoginHelper().login(Account.builder().login("lesya").password("qwerty007").build());
        Assert.assertFalse(appManager.getLoginHelper().isLoggedIn());
    }

}
