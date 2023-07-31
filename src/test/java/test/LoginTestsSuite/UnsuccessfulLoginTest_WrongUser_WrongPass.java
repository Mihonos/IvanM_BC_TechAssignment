package test.LoginTestsSuite;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

public class UnsuccessfulLoginTest_WrongUser_WrongPass extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUpTest(){
             betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void UnsuccessfulLogin_WrongUser_WrongPass(){
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        Assert.assertTrue(betExpertLoginPage.invalidUserWarningMsg("sdsgddhgfhdf", "kurblonvcnb"));
    }
}
