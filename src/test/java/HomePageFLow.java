import Controlers.Message;
import Models.HomePageDetails;
import Pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePageFLow {

    public static WebDriver driver;
    public static String title;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        
    }
    @After
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void shouldVerifyWithSucessfullHomePageTitle() throws InterruptedException{
        new HomePage(driver).open();
        String title = new Message(driver).returnTitle();
        Assert.assertEquals(HomePageDetails.VALID_TITLE.getHomeTitle(), title);

    }

}