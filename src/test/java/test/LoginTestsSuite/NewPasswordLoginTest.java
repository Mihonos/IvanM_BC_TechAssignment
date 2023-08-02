package test.LoginTestsSuite;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

public class NewPasswordLoginTest extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUp(){
        betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void SuccessfulLoginTest(){
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        betExpertLoginPage.changePass("sivac", "kombinac18");
        betExpertLoginPage.openLoginForm();
        betExpertLoginPage.newPassLogin("sivac", "brutalni18");
    }
}
