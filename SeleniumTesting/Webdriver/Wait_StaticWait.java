package Webdriver;

import AutomationFC.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import AutomationFC.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
public class Wait_StaticWait {
    // Static wait is a wait that is applied to all elements in the script.
    // It is defined once and is applied throughout the script.
    // It is used to define the maximum wait time for the script to wait for an element to be found.
    // If the element is found before the wait time is over, the script will continue.
    // If the element is not found before the wait time is over, the script will throw an exception.
    // The static wait is set using the Thread.sleep() method.
    // The static wait is set in milliseconds.
    // The static wait is set to 5000 milliseconds in this example.
    // The static wait is set
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
        driver.get("https://demo.nopcommerce.com/register");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
    @Test(priority = 1, description = "")
    public void TC01_Dont_Set() throws InterruptedException {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//div[@id=\"start\"]//button")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"finish\"]//h4")).getText(), "Hello World!");
    }
}
