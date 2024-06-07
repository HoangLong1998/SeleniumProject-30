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
import org.openqa.selenium.support.ui.Select;


public class CustomDropDown_TC06 {
    WebDriver driver;
    WebDriverWait wait;
    CommonUtils commonUtils = new CommonUtils();
    Select select;

    /**
     * This method sets up the initial state of the test cases.
     * It initializes the WebDriver, WebDriverWait and navigates to the Rode website.
     */
    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test(priority = 1, description = "Jquery dropdown")
    public void jQuery_Dropdown() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        WebElement dropdown = driver.findElement(By.xpath("//span[@id=\"speed-button\"]"));
        WebElement options = driver.findElement(By.xpath("//ul[@id=\"speed-menu\"]"));
        commonUtils.selectOptionInCustomDropDownByTagName(dropdown,options,"Slower", "li");
        String selectedOption =  dropdown.getAttribute("textContent");
        Assert.assertEquals(selectedOption, "Slower");
    }

    @Test(priority = 2, description = "React JS")
    public void reactJS_dropdown(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class, \"selection dropdown\")]//div[contains(@class,\"divider\")]"));
        WebElement options = driver.findElement(By.xpath("//div[contains(@class, \"selection dropdown\")]"));
        commonUtils.selectOptionInCustomDropDownByTagName(dropdown,options,"Elliot Fu","div");
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.divider.text"))));
        String selectedOption =  driver.findElement(By.cssSelector("div.divider.text")).getAttribute("textContent");
        System.out.println(selectedOption);
        Assert.assertEquals(selectedOption, "Elliot Fu");
    }


}
