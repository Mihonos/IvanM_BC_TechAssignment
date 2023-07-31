package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.BetExpertLoginPage;

public class SpecialCharactersAndNumbersAcceptanceTest extends BaseTest {

    BetExpertLoginPage betExpertLoginPage;

    @Before
    public void SetUpTest(){
             betExpertLoginPage = new BetExpertLoginPage();
    }

    @Test
    public void SpecialCharactersAndNumbersAcceptanceTest(){
        betExpertLoginPage.cookieAccept();
        betExpertLoginPage.openLoginForm();
        Assert.assertTrue(betExpertLoginPage.specialCharactersAndNumbersAcceptance("sdsHFDER*TH/" +
                        "ŠČĆŽ{lžšš54538--!#}<!cer> '54'{n}sa",
                "kurblon246555>!??č--ĆŠPČĆ-><//*vvcnb"));
    }
}
