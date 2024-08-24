package Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import AutomationFC.CommonUtils;
import org.testng.Assert;
public class Wait_ElementStatus {


    WebDriver driver;
    WebDriverWait explicitWait;
    CommonUtils commonUtils = new CommonUtils();


    /**
     * This method sets up the initial state of the test cases.
     * It initializes the WebDriver, WebDriverWait and navigates to the Rode website.
     */
    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test(priority = 1, description = "")
    public  void TC01_Visible(){
        //Element need to be visible on UI
        driver.get("https://www.facebook.com/");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

    }
    @Test(priority = 2, description = "")
    public void TC02_Invisible(){
        //Element is not visible on UI
        driver.findElement(By.xpath("//a[@role=\"button\"][text()=\"Create new account\"]")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"login_form_container\"]")));

    }
    @Test(priority = 3, description = "")
    public void TC03_Presence(){
        //Element is present in DOM, don't care visible or invisible in UI

    }
    @Test(priority = 4, description = "")
    public void TC04_Staleness(){
        //Element is removed from DOM
        driver.get("https://www.facebook.com/");
        WebElement element = driver.findElement(By.xpath("//input[@id='email']"));
        driver.navigate().refresh();
        explicitWait.until(ExpectedConditions.stalenessOf(element));

    }



}
