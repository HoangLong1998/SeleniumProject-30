package AutomationFCUtils;
import org.openqa.selenium.By ;
import org.openqa.selenium.WebElement ;
import org.openqa.selenium.support.ui.Select ;
import org.openqa.selenium.WebDriver ;
import org.openqa.selenium.chrome.ChromeDriver ;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait ;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.UUID;

public class CommonUtils  {
    WebDriver driver;
    WebDriverWait wait;

    Select select;
    public void setTextToElement(WebElement element, String text){

     //  waitForElementToVisible(element);
        element.sendKeys(text);
    }
    public void clickElement(WebElement element){
      //  waitForElementToVisible(element);
        String textTo = element.toString();
        element.click();
        System.out.println( "WebElement " + textTo +  " has been clicked");
    }
//    public void waitForElementToVisible(WebElement ele){
//        // Driver still get NUll value
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(ele));
//    }
    public void selectOptionOnDefaultDropDown(WebElement element, String optionvalue) {
         select = new Select(element);
         select.selectByVisibleText(optionvalue);
    }
        public  String generateRandomEmail() {
            return UUID.randomUUID().toString() + "@example.com";
        }


}
