package AutomationFC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.UUID;

/**
 * This class contains utility methods for Selenium WebDriver operations.
 */
public class CommonUtils  {
    WebDriver driver;
    WebDriverWait wait;
    Select select;

    /**
     * This method sets the text of a WebElement.
     * @param element The WebElement to set the text for.
     * @param text The text to set.
     */
    public void setTextToElement(WebElement element, String text){
        element.sendKeys(text);
    }

    /**
     * This method clicks a WebElement.
     * @param element The WebElement to click.
     */
    public void clickElement(WebElement element){
        String textTo = element.toString();
        element.click();
        System.out.println( "WebElement " + textTo +  " has been clicked");
    }

    /**
     * This method selects an option in a dropdown WebElement by visible text.
     * @param element The dropdown WebElement.
     * @param optionvalue The visible text of the option to select.
     */
    public void selectOptionOnDefaultDropDown(WebElement element, String optionvalue) {
        select = new Select(element);
        select.selectByVisibleText(optionvalue);
    }

    /**
     * This method selects an option in a custom dropdown WebElement by visible text.
     * The dropdown is assumed to be a list of 'li' elements.
     * If the option is found, it is clicked and a message is printed to the console.
     * If the option is not found, a message is printed to the console.
     *  Th function is used for React dropdown
     * @param element The dropdown WebElement.
     * @param optionvalue The visible text of the option to select.
     */
    public void selectOptionInCustomDropDownByTagName(WebElement element,WebElement optionlist, String optionvalue, String tagname) {
        int select = 0;
        element.click();

        List<WebElement> lst_options = optionlist.findElements(By.tagName(tagname));
        // Loop through the options and select the one that matches the optionvalue
        for (WebElement option: lst_options) {
            System.out.println(option.getText());
            if (option.getText().equals(optionvalue)) {
                option.click();
                select++;
                break;
            }
        }
        if(select == 0) {
            System.out.println("Option not found");
        }
        else {
            System.out.println("Option " + optionvalue + " has been selected");
        }

    }



    /**
     * This method generates a random email address.
     * @return The generated email address.
     */
    public  String generateRandomEmail() {
        return UUID.randomUUID().toString() + "@example.com";
    }

    /**
     * This method checks if a dropdown WebElement is a multi-select dropdown.
     * @param element The dropdown WebElement.
     */
    public void isMultiSelect(WebElement element) {
        select = new Select(element);
        Assert.assertFalse(select.isMultiple());
    }
}