package page;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

public class BetExpertLoginPage extends BaseTest {

    public BetExpertLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement iAcceptBtn;
    @FindBy(css = "span[class='ng-tns-c7-4']")
    WebElement loginFormBtn;
    @FindBy(xpath = "//button[@title='Login with Facebook']")
    WebElement fcbLoginBtn;
    @FindBy(css = "input[name='login']")
    WebElement loginBtn;
    @FindBy(xpath = "//a[@href='https://www.bettercollective.com']")
    WebElement bcLinkBtn;
    @FindBy(css = "input[placeholder='username or email']")
    WebElement emailTxtField;
    @FindBy(css = "input[placeholder='password']")
    WebElement passwTxtField;
    @FindBy(css = "button[title='Login']")
    WebElement formLoginBtn;
    @FindBy(css = ".be-form__alert")
    WebElement invalidUserMsg;

    public void cookieAccept() {
        wdWait.until(ExpectedConditions.elementToBeClickable(iAcceptBtn)).click();
    }

    public void openLoginForm() {
        wdWait.until(ExpectedConditions.elementToBeClickable(loginFormBtn)).click();
    }

    public void redirectionToFacebookPage() throws IOException {
        fcbLoginBtn.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("src/screenshots/fcbScreenshot.png"));
        }
    }

    public void redirectionToBCPage() throws IOException {
        wdWait.until(ExpectedConditions.visibilityOf(bcLinkBtn)).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("src/screenshots/BCScreenshot.png"));

            //driver.navigate().forward();
            //return driver.getCurrentUrl();
        }
    }

    public boolean invalidUserWarningMsg(){
        emailTxtField.sendKeys("sds");
        passwTxtField.sendKeys("kurb");
        formLoginBtn.click();
        wdWait.until(ExpectedConditions.visibilityOf(invalidUserMsg));
        return invalidUserMsg.isDisplayed();
    }
}


