package Webdriver;

import AutomationFC.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Wait_FluentWait {
    WebDriver driver;
    WebDriverWait explicitWait;
    CommonUtils commonUtils = new CommonUtils();
    FluentWait<WebElement> fluentWait;


    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public WebElement findElement(By locator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
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
        FluentWait<WebElement> fluentWait = new FluentWait<>(element);
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.isDisplayed();
            }
        });
        return element.isDisplayed();
    }

    //Ham clickElement_01 nhanh hon clickElement_02
    public void clickElement_01(WebElement element) {
        FluentWait<WebElement> fluentWait = new FluentWait<>(element);
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(new Function<WebElement, WebElement>() {
            @Override
            public WebElement apply(WebElement element) {
                return element;
            }
        }).click();
    }

    public void clickElement_02(WebElement element) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element)).click();
    }


    public String getTextElement(WebElement element) {
        FluentWait<WebElement> fluentWait = new FluentWait<>(element);
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        return fluentWait.until(new Function<WebElement, String>() {
            @Override
            public String apply(WebElement element) {
                return element.getText();
            }
        });

    }
 public boolean isSendcondMatching(WebElement element, String value) {
        FluentWait<WebElement> fluentWait = new FluentWait<>(element);
        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        return fluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.getText().endsWith(value);
            }
        });
    }


    @Test(priority = 2, description = "")
    public void TC01_dynamicLoading_02() throws InterruptedException {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        clickElement_01(findElement(By.xpath("//div[@id=\"start\"]//button")));
        Assert.assertEquals(getTextElement(findElement(By.xpath("//div[@id=\"finish\"]//h4"))), "Hello World!");
    }

    @Test(priority = 1, description = "")
    public void TC02_countDown() throws InterruptedException {
        driver.get("https://automationfc.github.io/fluent-wait/");
        WebElement txt_countDown = findElement(By.xpath("//div[@id=\"javascript_countdown_time\"]"));
        Assert.assertTrue(isElementDisplayed(txt_countDown));
        Assert.assertTrue(isSendcondMatching(txt_countDown, "00"));
    }
}