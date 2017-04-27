package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 27/04/17.
 */
public abstract class FunctionalDetals {

    public String getMessage(WebDriver driver, String id){

        String message;
        message = driver.findElement(By.id(id)).getText();
        return message;

    }

}
