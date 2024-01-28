package page;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BetExpertLoginPage extends BaseTest {

    public BetExpertLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement iAcceptBtn;
    @FindBy(css = "span[class='ng-tns-c2102146453-4']")
    WebElement loginBtn;
    @FindBy(xpath = "//button[@title='Login with Facebook']")
    WebElement fcbLoginBtn;
    @FindBy(xpath = "//a[@href='https://www.bettercollective.com']")
    WebElement bcLinkBtn;
    @FindBy(css = "input[formcontrolname='username']")
    WebElement emailTxtField;
    @FindBy(css = "input[placeholder='password']")
    WebElement passwTxtField;
    @FindBy(css = "button[title='Login']")
    WebElement formLoginBtn;
    @FindBy(xpath = "//div[text()=' Invalid user ']")
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
    @FindBy(xpath = "//div[@class='be-p-top--medium']/be-link/a[contains(.,'Sign up')]")
    WebElement signUpFreeBtn;
    @FindBy(xpath = "//div[@class='be-p-top--medium']/be-link/a[contains(.,'Request')]")
    WebElement forgotPassBtn;
    @FindBy(xpath = "//h2[text()=(' Sign up with email ')]")
    WebElement signUpHeader;
    @FindBy(xpath = "//h2[text()=(' Request password change link ')]")
    WebElement passwordChangeHeader;
    @FindBy(id = "be-google-social-button")
    WebElement googleLinkBtn;
    @FindBy(xpath = "//div/a[contains(.,' Settings ')]")
    WebElement settingsbtn;
    @FindBy(css = "input[formcontrolname='currentPassword']")
    WebElement currentPassBtn;
    @FindBy(css = "input[placeholder='Enter new password']")
    WebElement enterNewPass;
    @FindBy(css = "input[placeholder='Repeat new password']")
    WebElement repeatNewPass;
    @FindBy(xpath = "//div[text()=' Log out ']")
    WebElement logoutBtn;
    @FindBy(css = "div[class='be-p-bottom--small']")
    WebElement updatePass;
    @FindBy(id = "logo")
    WebElement googleLogoBtn;

    public void cookieAccept() {
        wdWait.until(ExpectedConditions.elementToBeClickable(iAcceptBtn)).click();
    }

    public void openLoginForm() {
        wdWait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
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
    // method that checks if there are character number limits in the password textbox
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

    public void successfulLogin(String email, String password) {
        typeText(emailTxtField, email);
        typeText(passwTxtField, password);
        formLoginBtn.click();
        wdWait.until(ExpectedConditions.visibilityOf(userName)).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(profileBtn));
        String profileBtnName = profileBtn.getText();
        Assert.assertEquals("Profile", profileBtnName);
    }

    // method that checks if email and password fields accept mix of special characters and numbers
    public boolean specialCharactersAndNumbersAcceptance(String email, String password) {
        typeText(emailTxtField, email);
        typeText(passwTxtField, password);
        wdWait.until(ExpectedConditions.elementToBeClickable(formLoginBtn));
        return formLoginBtn.isEnabled();
    }

    public boolean signUpFreeRedirection() {
        wdWait.until(ExpectedConditions.elementToBeClickable(signUpFreeBtn)).click();
        wdWait.until(ExpectedConditions.visibilityOf(signUpHeader));
        return signUpHeader.isDisplayed();
    }

    public boolean forgotPasswordRedirection() {
        wdWait.until(ExpectedConditions.elementToBeClickable(forgotPassBtn)).click();
        wdWait.until(ExpectedConditions.visibilityOf(passwordChangeHeader));
        return passwordChangeHeader.isDisplayed();
    }

    public boolean blockedUserLoop(String email, String password) {
        int i = 0;

        while (i < 8) {
            checkBox.click();
            typeText(emailTxtField, email);
            typeText(passwTxtField, password);
            formLoginBtn.click();
            //wdWait.until(ExpectedConditions.elementToBeClickable(formLoginBtn));

            i++;
        }
        wdWait.until(ExpectedConditions.elementToBeClickable(blockedUserMsg));
        return blockedUserMsg.isDisplayed();
    }

    public void googleSignInRedirection() throws IOException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", googleLinkBtn);
        actions.moveToElement(googleLinkBtn).build().perform();
        googleLinkBtn.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("src/screenshots/googleSignInScreenshot.png"));
        }
    }

        public void changePass(String email, String password){
            typeText(emailTxtField, email);
            typeText(passwTxtField, password);
            formLoginBtn.click();
            wdWait.until(ExpectedConditions.visibilityOf(userName)).click();
            wdWait.until(ExpectedConditions.elementToBeClickable(settingsbtn)).click();
            wdWait.until(ExpectedConditions.elementToBeClickable(currentPassBtn)).sendKeys("kombinac18");
            wdWait.until(ExpectedConditions.elementToBeClickable(enterNewPass)).sendKeys("brutalni18");
            wdWait.until(ExpectedConditions.elementToBeClickable(repeatNewPass)).sendKeys("brutalni18");
            wdWait.until(ExpectedConditions.elementToBeClickable(updatePass)).click();
            userName.click();
            logoutBtn.click();
        }

    public void newPassLogin(String email, String password) {
        typeText(emailTxtField, email);
        typeText(passwTxtField, password);
        formLoginBtn.click();
        wdWait.until(ExpectedConditions.visibilityOf(userName)).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(profileBtn));
        String profileBtnName = profileBtn.getText();
        Assert.assertEquals("Profile", profileBtnName);
    }

    public boolean rememberMeFunction(String email, String password){
        typeText(emailTxtField, email);
        typeText(passwTxtField, password);
        checkBox.click();
        formLoginBtn.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.bettingexpert.com/");
        wdWait.until(ExpectedConditions.visibilityOf(userName));
        return userName.isDisplayed();
    }

    }





