package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Urls.BasePage.LINK_NAME_ORDERS;

/**
 * Created by grodrigu on 09/05/17.
 */
public class DashboardsPage extends FunctionalDetails{

    public void clickOnLinkOrders(WebDriver driver){

        driver.findElement(By.linkText(LINK_NAME_ORDERS)).click();
    }

}
