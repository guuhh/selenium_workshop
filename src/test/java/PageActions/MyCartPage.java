package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 04/05/17.
 */
public class MyCartPage{


    public String getBookTitleOnMyCart(WebDriver driver, By productTitle){

        return driver.findElement(productTitle).getText();

    }

    public void clickOnLinkContinue(WebDriver driver, String linkContinue){

        driver.findElement(By.linkText(linkContinue)).click();
    }

    public void clickOnLinkRemover(WebDriver driver, By byTD){

        driver.findElement(byTD).click();
    }
}
