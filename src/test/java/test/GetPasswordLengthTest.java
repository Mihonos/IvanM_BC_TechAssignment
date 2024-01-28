package test;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

public class GetPasswordLengthTest extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUpTest(){

        betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void GetPasswordLengthTest(){
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        betExpertLoginPage.checkPassLength();
    }
}
