package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 17/04/17.
 */
public class HomePage {

    public String getTitle(WebDriver driver){

       return driver.getTitle();
    }

    public void clickOnBook(WebDriver driver, String bookName){

        driver.findElement(By.linkText(bookName)).click();

    }

    public void clickOnLinkSignUp(WebDriver driver, String linkSignUp){

        driver.findElement(By.linkText(linkSignUp)).click();

    }

    public void clickOnLinkLogin(WebDriver driver, String linkLogin){

        driver.findElement(By.linkText(linkLogin)).click();

    }

    public void clickOnLinkLogout(WebDriver driver, String linkLogin){

        driver.findElement(By.linkText(linkLogin)).click();

    }

}
