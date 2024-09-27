package Webdriver;

import AutomationFC.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait_Implicit {
    // Implicit wait is a global wait that is applied to all elements in the script.
    // It is defined once and is applied throughout the script.
    // It is used to define the maximum wait time for the script to wait for an element to be found.
    // If the element is found before the wait time is over, the script will continue.
    // If the element is not found before the wait time is over, the script will throw an exception.
    // The implicit wait is set using the driver.manage().timeouts().implicitlyWait() method.
    // The implicit wait is set in seconds.
    // The implicit wait is set to 10 seconds in this example.
    // The implicit wait is set


    // The implicit wait is set using the driver.manage().timeouts().implicitlyWait() method.

    WebDriver driver;
    CommonUtils commonUtils = new CommonUtils();


    /**
     * This method sets up the initial state of the test cases.
     * It initializes the WebDriver, WebDriverWait and navigates to the Rode website.
     */
    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.nopcommerce.com/register");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test(priority = 1, description = "")
    public void TC01_Dont_Set() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//div[@id=\"start\"]//button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"finish\"]//h4")).getText(), "Hello World!");
    }
        // Must set the implicit wait in beforeClass to avoid the implicit wait from affecting the test case, as the implicit wait is a global wait that is applied to all findElement function in the script.
}
