package Pages;

import Urls.UrlsSugar;
import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 17/04/17.
 */
public class HomePage {
    private WebDriver driver;
    private UrlsSugar urlHome;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage open(){
        driver.get(urlHome.URLHOME);
        return this;
    }

}
