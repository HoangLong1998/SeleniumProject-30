package Webdriver;

import AutomationFC.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.function.Function;

public class Wait_FluentWait {
    WebDriver driver;
    WebDriverWait explicitWait;
    CommonUtils commonUtils = new CommonUtils();
    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        fluentWait = new FluentWait<WebDriver>(driver);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public WebElement findElement(By locator) {
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        return fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public boolean isElementDisplayed(WebElement element) {
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        return fluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }
        });
    }

    public void clickElement(WebElement element) {
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return element;
            }
        }).click();
    }
}