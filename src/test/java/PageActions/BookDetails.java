package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 18/04/17.
 */
public class BookDetails extends  FunctionalDetails{

    private By productTitle =  By.xpath("//*[@id=\"container\"]/h2");
    private By productPrice =  By.xpath("//*[@id=\"product-description\"]/p[2]");
    private By productAuthor =  By.xpath("//*[@id=\"product-description\"]/p[3]");


    public String getBookTitle(WebDriver driver){

        return driver.findElement(productTitle).getText();

    }


    public String getBookPrice(WebDriver driver){

        return driver.findElement(productPrice).getText();

    }


    public String getBookAuthor(WebDriver driver){

        return driver.findElement(productAuthor).getText();

    }


    public void clickOnAddOnCart(WebDriver driver, String addCart){

        driver.findElement(By.linkText(addCart)).click();

    }
}
