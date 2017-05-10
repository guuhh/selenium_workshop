package Setup;

import PageActions.*;
import Urls.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static Urls.BasePage.SEED_ENDPOINT;
import static io.restassured.RestAssured.get;

/**
 * Created by grodrigu on 18/04/17.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Setup {

    public static WebDriver driver;
    public  HomePage home = new HomePage();
    public  BookDetails bookDet = new BookDetails();
    public  SignupPage signup = new SignupPage();
    public  LoginPage login = new LoginPage();
    public  MyCartPage mycart = new MyCartPage();
    public DashboardsPage dash = new DashboardsPage();


    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BasePage.BASE_URL);

    }


    @After
    public void tearDown(){
        get(BasePage.BASE_URL + SEED_ENDPOINT).then().statusCode(200);
        //driver.quit();
    }
}
