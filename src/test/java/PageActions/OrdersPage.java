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

    public String getUserName(WebDriver driver, String nameCustomer){

        List<WebElement> CustList = driver.findElements(By.className(NAME_ODD_ROW));
        String total = null;

        for(int i=0; i < CustList.size(); i++){
            String ActCustName = CustList.get(i).getText();
            System.out.println(ActCustName);


            if(ActCustName.contains(nameCustomer)){
                total = CustList.get(i).getAttribute(NAME_CUSTOMER_NAME);
                break;
            }
        }
        return total;
    }

    public String getTotalValueOrder(WebDriver driver, String totalValue){

        List<WebElement> CustList = driver.findElements(By.className(NAME_ODD_ROW));
        String name = null;

        for(int i=0; i < CustList.size(); i++){
            String ActCustName = CustList.get(i).getText();
            System.out.println(ActCustName);


            if(ActCustName.contains(totalValue)){
                name = CustList.get(i).getAttribute(NAME_TOTAL_VALUE_ORDER);
                break;
            }
        }
        return name;
    }
}
