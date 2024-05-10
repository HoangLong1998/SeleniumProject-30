package Webdriver;

import com.sun.source.tree.ImportTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import AutomationFCUtils.CommonUtils;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class DropdownList_Default {
    WebDriver driver;
    WebDriverWait wait;
    CommonUtils commonUtils = new CommonUtils();

    Select select;

    @BeforeClass
    public void initPage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test(priority = 1, description = "Register form")
    public void registerForm() {
        // Step 01: Click Register link
        commonUtils.clickElement(driver.findElement(By.xpath("//a[@class=\"ico-register\"]")));

        // Step 02: Input valid data to all fields
        commonUtils.setTextToElement(driver.findElement(By.xpath("//input[@id=\"FirstName\"]")), "Robert");
        commonUtils.setTextToElement(driver.findElement(By.xpath("//input[@id=\"LastName\"]")), "Hoang");
        commonUtils.setTextToElement(driver.findElement(By.xpath("//input[@id=\"Email\"]")), commonUtils.generateRandomEmail());
        commonUtils.setTextToElement(driver.findElement(By.xpath("//input[@id=\"Password\"]")), "123456");
        commonUtils.setTextToElement(driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")), "123456");

        // Step 03: Select Day, Month, Year
        WebElement day = driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"));
        commonUtils.selectOptionOnDefaultDropDown(day, "1");

        WebElement month = driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"));
        commonUtils.selectOptionOnDefaultDropDown(month, "October");

        WebElement year = driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"));
        commonUtils.selectOptionOnDefaultDropDown(year, "1998");

        commonUtils.clickElement(driver.findElement(By.xpath("//button[@id=\"register-button\"]")));
    }

    @Test(priority = 2, description = "Verify register success")
    public void verifyRegisterSuccess() {
        // Step 01: Click on My account button
        WebElement btnmyaccount = driver.findElement(By.xpath("//a[@class=\"ico-account\"]"));
        commonUtils.clickElement(btnmyaccount);
        // Step 02: Verify register success with DATE OF BIRTH
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "1");
        //Step 03: Verify register success with Month OF BIRTH
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "October");

        //Step 03: Verify register success with Year OF BIRTH
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "1998");

    }
}
