package test.WarningMessagesTestSuite;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

public class InactiveUserMsgTest extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUpTest(){
        betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void InvalidUserMessageTest() {
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        Assert.assertTrue(betExpertLoginPage.inactiveUserMsg("sivac", "kombinat18"));
    }
}
