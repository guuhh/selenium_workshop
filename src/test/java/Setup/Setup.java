package Setup;

import PageActions.BookDetails;
import PageActions.HomePage;
import PageActions.LoginPage;
import PageActions.SignupPage;
import Urls.URLS;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by grodrigu on 18/04/17.
 */
public class Setup {

    public static WebDriver driver;
    public HomePage home = new HomePage();
    public BookDetails bookDet = new BookDetails();
    public SignupPage signup = new SignupPage();
    public LoginPage login = new LoginPage();


    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get(URLS.URLHOME);

    }
    @After
    public void tearDown(){

        //driver.quit();
    }
}
