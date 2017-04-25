package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 18/04/17.
 */
public class BookDetails {

    private static By productTitle =  By.xpath("//*[@id=\"container\"]/h2");
    private static By productPrice =  By.xpath("//*[@id=\"product-description\"]/p[2]");
    private static By productAuthor =  By.xpath("//*[@id=\"product-description\"]/p[3]");

    public String getBookTitle(WebDriver driver){

        return driver.findElement(productTitle).getText();

    }

    public String getBookPrice(WebDriver driver){

        return driver.findElement(productPrice).getText();

    }

    public String getBookAuthor(WebDriver driver){

        return driver.findElement(productAuthor).getText();

    }
}
