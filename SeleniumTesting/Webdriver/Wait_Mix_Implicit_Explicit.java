package Webdriver;
import AutomationFC.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class Wait_Mix_Implicit_Explicit {
    WebDriver driver;
    WebDriverWait explicitWait;
    CommonUtils commonUtils = new CommonUtils();
    WebElement uploadFileSection = driver.findElement(By.xpath("//span[text()=\"Upload Files\"]"));
    WebElement addFileButton = driver.findElement(By.xpath("//div[@id=\"filesUpload\"]//button[contains(@class,\"filesUploadButton\")]"));
    WebElement spinnerLoading = driver.findElement(By.xpath("//div[contains(@class,\"mainUploadInitInfo\")]//div[@class=\"spinner-border\"]"));
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

}
