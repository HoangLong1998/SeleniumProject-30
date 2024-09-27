package Webdriver;
import AutomationFC.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadFile {
    WebDriver driver;
    CommonUtils commonUtils = new CommonUtils();

    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
