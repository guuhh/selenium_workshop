package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 04/05/17.
 */
public class MyCartPage extends FunctionalDetails{

    public static By indexProductTitle;
    public static final String NAME_CHECKOUT_BUTTON = "commit";
    public static final By RemoveLink = By.xpath("//*[@id=\"container\"]/table/tbody/tr[2]/td[3]/a");
    public static final By EmptyCartText = By.xpath("//*[@id=\"container\"]/p");

    public String getEmptyMyCart(WebDriver driver){

        return driver.findElement(EmptyCartText).getText();

    }

    public String getBookTitleOnMyCart(WebDriver driver, int indexBookRow){

        String xPath = "//*[@id=\"container\"]/table/tbody/tr["+indexBookRow+"]/td[1]";
        indexProductTitle = By.xpath(xPath);

        return driver.findElement(indexProductTitle).getText();

    }

    public void clickOnLinkContinue(WebDriver driver, String linkContinue){

        driver.findElement(By.linkText(linkContinue)).click();
    }

    public void clickOnLinkRemover(WebDriver driver){

        driver.findElement(RemoveLink).click();
    }

    public void clickOnCheckout(WebDriver driver){
        driver.findElement(By.name(NAME_CHECKOUT_BUTTON)).click();
    }
}
