package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import AutomationFCUtils.CommonUtils;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

/**
 * This class contains test cases for the default dropdown functionality on the Rode website.
 */
public class DefaultDropdown_TC05 {
    WebDriver driver;
    WebDriverWait wait;
    CommonUtils commonUtils = new CommonUtils();

    /**
     * This method sets up the initial state of the test cases.
     * It initializes the WebDriver, WebDriverWait and navigates to the Rode website.
     */
    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.rode.com/wheretobuy");
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * This test case checks if the country dropdown is a multi-select dropdown.
     */
    @Test(priority = 1, description = "Check the dropdown is multi-select")
    public void isMultiSelect_Country() {
        // Step 01: Click on Select your country
        WebElement drp_Country = driver.findElement(By.xpath("//select[@name=\"country\"]"));
        commonUtils.isMultiSelect(drp_Country);
    }

    /**
     * This test case searches for a city in Vietnam.
     */
    @Test(priority = 2, description = "Search city with Viet nam country")
    public void searchCity() {
        // Step 01: Click on Select your country
        WebElement drp_Country = driver.findElement(By.xpath("//select[@name=\"country\"]"));
        WebElement txt_SearchInput = driver.findElement(By.xpath("//input[@id=\"map_search_query\"]"));
        WebElement btn_Search = driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]"));

        commonUtils.selectOptionOnDefaultDropDown(drp_Country, "Vietnam");
        commonUtils.setTextToElement(txt_SearchInput, "Ho Chi Minh");
        commonUtils.clickElement(btn_Search);
    }

    /**
     * This test case verifies that the search result contains 16 dealers.
     */
    @Test(priority = 3, description = "Verify the search result")
    public void verifySeachResult_16Dealers() {
        // Step 01: Verify the search result
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> lst_Dealers = driver.findElements(By.xpath("//h3[text()=\"Dealers\"]/following-sibling::div//h4"));
        System.out.println("Number of dealers: " + lst_Dealers.size());

        Assert.assertEquals(lst_Dealers.size() ,16);

        for (WebElement dealer : lst_Dealers) {
            String txt_Dealer = dealer.getText();
            System.out.println(txt_Dealer);
        }
    }
}