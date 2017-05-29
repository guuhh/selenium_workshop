package Setup;

import PageActions.*;
import Urls.BasePage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static Urls.BasePage.SEED_ENDPOINT;
import static io.restassured.RestAssured.get;

/**
 * Created by grodrigu on 18/04/17.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public abstract class Setup {

    public static WebDriver driver;
    public HomePage home = new HomePage();
    public BookDetails bookDet = new BookDetails();
    public SignupPage signup = new SignupPage();
    public LoginPage login = new LoginPage();
    public MyCartPage mycart = new MyCartPage();
    public DashboardsPage dash = new DashboardsPage();
    public OrdersPage order = new OrdersPage();


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
        driver.quit();
    }


    @Test
    public static void exampleLoginAmazon(){

        String parcialMessage = "Luiz";
        WebElement element;

        element = driver.findElement(By.id("ap_email"));
        element.sendKeys("gustavo@gmail.com");
        element =  driver.findElement(By.id("ap_password"));
        element.sendKeys("23456");
        element = driver.findElement(By.id("signInSubmit"));
        element.click();

        WebElement linkElement;
        List<WebElement> spanElements;
        linkElement = driver.findElement(By.id("nav-link-accountList"));
        spanElements = linkElement.findElements(By.className("nav-line-1"));
        String successfulMessage = spanElements.get(0).toString();

        Assert.assertTrue(successfulMessage.contains(parcialMessage));

    }
}
