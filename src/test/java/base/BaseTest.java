package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdWait;
    public static Actions actions;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.bettingexpert.com/");
        actions = new Actions(driver);
    }



    public void typeText(WebElement element, String text){
        try {
            wdWait.until(ExpectedConditions.visibilityOf(element));

            element.clear();
            element.sendKeys(text);

            System.out.println("Typed text: " + text );
        } catch (StaleElementReferenceException e){

            element.clear();
            element.sendKeys(text);

            System.out.println("Typed text: " + text );
        }

    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
