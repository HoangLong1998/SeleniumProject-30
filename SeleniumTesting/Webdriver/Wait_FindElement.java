package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import AutomationFC.CommonUtils;
import org.testng.Assert;

public class Wait_FindElement {


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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.get("https://demo.nopcommerce.com/register");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test(priority = 1, description = "")
    public void TC01_findElement() {
        // If find 1 element, no need to wait 13s
        driver.findElement(By.xpath("//input[@id=\"FirstName\"]"));

        // If find more than 1 elements => Return 4 elements=> Find and take action on the first element

        driver.findElement(By.xpath("//input[@type=\"text\"]"));

        // If not find any element => failed test cases after 13s
    }

    @Test(priority = 2, description = "")
    public void TC02_findElements() {
        // If find 1 element
        List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\"FirstName\"]"));
        // If find more than 1 elements
        List<WebElement> elementss = driver.findElements(By.xpath("//input[@type=\"text\"]"));
        // If not find any element
        // => Size of List = 0
    }

}
