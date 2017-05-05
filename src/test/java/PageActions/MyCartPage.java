package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 04/05/17.
 */
public class MyCartPage{

    private By productTitle =  By.xpath("//*[@id=\"container\"]/table/tbody/tr[2]/td[1]");


    public String getBookTitleOnMyCart(WebDriver driver){

        return driver.findElement(productTitle).getText();

    }
}
