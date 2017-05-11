package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by grodrigu on 10/05/17.
 */
public class OrdersPage extends  FunctionalDetails {

    public static final String NAME_ODD_ROW = "odd";
    public static final String NAME_CUSTOMER_NAME = "col col-customer";
    public static final String NAME_TOTAL_VALUE_ORDER = "col col-total";


    public String getLastRowInformation(WebDriver driver){

        String lastIdRow =  this.getLastIDRow(driver, NAME_ODD_ROW);
        List<WebElement> findBody = driver.findElements(By.id(lastIdRow));
        String value = findBody.get(0).getText();

        return value;
    }

}
