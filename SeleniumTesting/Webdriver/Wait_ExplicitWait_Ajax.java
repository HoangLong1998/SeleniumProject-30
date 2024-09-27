package Webdriver;

import AutomationFC.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Wait_ExplicitWait_Ajax {
    WebDriver driver;
    CommonUtils commonUtils = new CommonUtils();

    WebDriverWait explicitWait;
    String cal_Calendar = "//div[@class=\"calendarContainer\"]";
    String txt_SelectedDate = "//span[@id=\"ctl00_ContentPlaceholder1_Label1\"]";
    String date = "//td[@title=\"%s\"]";

    /**
     * This method sets up the initial state of the test cases.
     * It initializes the WebDriver, WebDriverWait and navigates to the Rode website.
     */
    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @Test(priority = 1, description = "")
    public void TC01_Calendar() throws InterruptedException {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cal_Calendar)));
        Assert.assertTrue(driver.findElement(By.xpath(cal_Calendar)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(txt_SelectedDate)).getText(), "No Selected Dates to display.");
        String currentDate = commonUtils.getCurrentDay();
        System.out.println("Current Date: " + currentDate);
        String formaterCurrentDate = commonUtils.formatedDate("EEEE, MMMM dd, yyyy", currentDate);
        driver.findElement(By.xpath(String.format(date,formaterCurrentDate))).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"raDiv\"]")));
        String selectedDate = driver.findElement(By.xpath(txt_SelectedDate)).getText();
        String formatterSelectedDate = commonUtils.convertDateStringToAnotherDateFormat("EEEE, MMMM d, yyyy", "dd/MM/yyyy", selectedDate);
        System.out.println("Selected Date: " + formatterSelectedDate);
        Assert.assertEquals(formatterSelectedDate, commonUtils.formatedDate("dd/MM/yyyy", currentDate));
    }

    @Test(priority = 2, description = "")
    public void TC02(){
        driver.get("https://gofile.io/?t=uploadFiles");

    }

}

