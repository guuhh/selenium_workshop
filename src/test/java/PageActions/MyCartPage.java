package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 04/05/17.
 */
public class MyCartPage extends FunctionalDetails{

    public static final String NAME_CHECKOUT_BUTTON = "commit";

    public String getBookTitleOnMyCart(WebDriver driver, By productTitle){

        return driver.findElement(productTitle).getText();

    }

    public void clickOnLinkContinue(WebDriver driver, String linkContinue){

        driver.findElement(By.linkText(linkContinue)).click();
    }

    public void clickOnLinkRemover(WebDriver driver, By byTD){

        driver.findElement(byTD).click();
    }

    public void clickOnCheckout(WebDriver driver){
        driver.findElement(By.name(NAME_CHECKOUT_BUTTON)).click();
    }
}
