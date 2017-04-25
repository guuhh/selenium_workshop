package Setup;

import PageActions.BookDetails;
import PageActions.HomePage;
import Urls.URLS;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by grodrigu on 18/04/17.
 */
public class Setup {

    public static WebDriver driver;
    public HomePage home = new HomePage();
    public BookDetails bookDet = new BookDetails();


    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(URLS.URLHOME);

    }
    @After
    public void tearDown(){
        
        driver.quit();
    }
}
