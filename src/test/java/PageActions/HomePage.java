package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by grodrigu on 17/04/17.
 */
public class HomePage {

    private static WebElement element;
    private static String bookName;

    public String getTitle(WebDriver driver){

       return driver.getTitle();
    }


    public void clickOnBook(WebDriver driver, String bookName){
        this.bookName = bookName;
        driver.findElement(By.linkText(bookName)).click();

    }

}
