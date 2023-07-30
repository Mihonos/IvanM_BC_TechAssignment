package page;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
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
    @FindBy(css = "input[formcontrolname='username']")
    WebElement emailTxtField;
    @FindBy(css = "input[placeholder='password']")
    WebElement passwTxtField;
    @FindBy(css = "button[title='Login']")
    WebElement formLoginBtn;
    @FindBy(css = "//div[@class='be-form__alert'][contains(.,' Invalid user ')]")
    WebElement invalidUserMsg;
    @FindBy(xpath = "//div[@class='be-form__alert'][contains(.,' Inactive user ')]")
    WebElement inactiveUserMsg;
    @FindBy(xpath = "//div[@class='be-form__alert'][contains(.,' Invalid password ')]")
    WebElement invalidPasswMsg;
    @FindBy(xpath = "//div[@class='be-form__alert'][contains(.,' User is blocked ')]")
    WebElement blockedUserMsg;
    @FindBy(xpath = "//div[@class='be-form__alert ng-star-inserted'][contains(.,' Please enter a username ')]")
    WebElement usernameWarnMsg;
    @FindBy(xpath = "//div[@class='be-form__alert ng-star-inserted'][contains(.,' Please write a password ')]")
    WebElement passwordWarnMsg;
    @FindBy(css = "div[class='be-checkbox-wrap__left']")
    WebElement checkBox;
    @FindBy(xpath = "//div[@class='be-row be-align--middle']/div[contains(.,'sivac')]")
    WebElement userName;
    @FindBy(xpath = "//div/a[contains(.,'Profile ')]")
    WebElement profileBtn;

    public void cookieAccept() {
        wdWait.until(ExpectedConditions.elementToBeClickable(iAcceptBtn)).click();
    }

    public void openLoginForm() {
        wdWait.until(ExpectedConditions.elementToBeClickable(loginFormBtn)).click();
    }

    // Methods checking redirections
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

    // Methods checking Warning Messages
    public boolean invalidUserWarningMsg(String email, String password) {
        typeText(emailTxtField, email);
        typeText(passwTxtField, password);
        formLoginBtn.click();
        wdWait.until(ExpectedConditions.visibilityOf(invalidUserMsg));
        return invalidUserMsg.isDisplayed();
    }

    // This method works only before activating the account, after that InactiveMsgTest fails
    public boolean inactiveUserMsg(String email, String password) {
        typeText(emailTxtField, email);
        typeText(passwTxtField, password);
        formLoginBtn.click();
        wdWait.until(ExpectedConditions.visibilityOf(inactiveUserMsg));
        return inactiveUserMsg.isDisplayed();
    }

    public boolean invalidPasswordMsg(String email, String password) {
        typeText(emailTxtField, email);
        typeText(passwTxtField, password);
        formLoginBtn.click();
        wdWait.until(ExpectedConditions.visibilityOf(invalidPasswMsg));
        return invalidPasswMsg.isDisplayed();
    }

    public boolean enterUsernameWarnMsg(String email) {
        typeText(emailTxtField, email);
        checkBox.click();
        wdWait.until(ExpectedConditions.visibilityOf(usernameWarnMsg));
        return usernameWarnMsg.isDisplayed();
    }

    public boolean enterPasswWarnMsg(String password) {
        typeText(passwTxtField, password);
        checkBox.click();
        wdWait.until(ExpectedConditions.visibilityOf(passwordWarnMsg));
        return passwordWarnMsg.isDisplayed();
    }

    public void checkPassLength() {
        // Clear already typed value.
        passwTxtField.clear();

        // Get maxlength attribute of input box
        String maxLengthDefined = passwTxtField.getAttribute("maxlength");

        if (maxLengthDefined == null) {
            System.out.println("No limit is set.");
        } else {
            if (maxLengthDefined.equals("10")) {
                System.out.println("Max character limit is set as expected.");
            }
        }
    }

    public void successfulLogin(String email, String password){
        typeText(emailTxtField, email);
        typeText(passwTxtField, password);
        formLoginBtn.click();
        wdWait.until(ExpectedConditions.visibilityOf(userName)).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(profileBtn));
        String profileBtnName = profileBtn.getText();
        Assert.assertEquals("Profile", profileBtnName);
    }

}



