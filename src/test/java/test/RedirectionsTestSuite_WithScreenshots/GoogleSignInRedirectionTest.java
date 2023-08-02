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
        /*Assert.assertEquals("https://accounts.google.com/gsi/select?client_id=965144904215" +
                "-heotk8nflpr6otg143ca57lrlhr9b8h7.apps.googleusercontent.com&auto" +
                "_select=false&ux_mode=popup&ui_mode=card&as=ctH7orSglr1FdnzeEcJ7fA&channel" +
                "_id=6015a56c33fbeb1c7f05f2a9546bb707e62df8fe2622fb82919bd5f375b78c84&origin=" +
                "https%3A%2F%2Fwww.bettingexpert.com", betExpertLoginPage.googleSignInRedirection());*/
    }
}
