package Webdriver;

import AutomationFC.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Wait_ExplicitWait_Loading {
    WebDriver driver;
    CommonUtils commonUtils = new CommonUtils();

    WebDriverWait explicitWait;
    /**
     * This method sets up the initial state of the test cases.
     * It initializes the WebDriver, WebDriverWait and navigates to the Rode website.
     */

    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://automationfc.github.io/dynamic-loading/");

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
    @Test(priority = 1, description = "")
    public void TC01() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id=\"start\"]//button")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id=\"loading\"]")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"finish\"]//h4")).getText(), "Hello World!");
    }

    @Test(priority = 2, description = "")
    public void TC02() throws InterruptedException {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//div[@id=\"start\"]//button")).click();
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id=\"finish\"]//h4"))));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"finish\"]//h4")).getText(), "Hello World!");
    }
}

