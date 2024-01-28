package test.RedirectionsTestSuite_WithScreenshots;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

import java.io.IOException;

public class Facebook_screenshot_RedirectionTest extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUpTest() {
        betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void FacebookRedirectionTest() throws IOException {
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        betExpertLoginPage.redirectionToFacebookPage();
    }
}
