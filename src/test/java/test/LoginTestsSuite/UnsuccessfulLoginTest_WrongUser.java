package test.LoginTestsSuite;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

public class UnsuccessfulLoginTest_WrongUser extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUpTest(){
             betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void WrongUsernameTest(){
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        Assert.assertTrue(betExpertLoginPage.invalidUserWarningMsg("si", "brutalni18"));
    }
}
