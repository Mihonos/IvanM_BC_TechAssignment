package test.RedirectionsTestSuite_WithScreenshots;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

import java.io.IOException;

public class GoogleSignInRedirectionTest extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUpTest() {
        betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void GoogleSignInRedirectionTest() throws IOException {
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        betExpertLoginPage.googleSignInRedirection();
    }
}
