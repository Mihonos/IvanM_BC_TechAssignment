package test.LoginTestsSuite;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

public class SuccessfulLoginTest_Email extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUp(){
        betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void SuccessfulLoginTest(){
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        betExpertLoginPage.successfulLogin("kk@mailinator.com", "kombinac18");
    }
}
