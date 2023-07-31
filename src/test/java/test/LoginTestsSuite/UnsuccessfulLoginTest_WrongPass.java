package test.LoginTestsSuite;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

public class UnsuccessfulLoginTest_WrongPass extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUpTest(){
             betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void WrongPasswordTest(){
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        Assert.assertTrue(betExpertLoginPage.invalidPasswordMsg("sivac", "kombiyfna18"));
    }
}
