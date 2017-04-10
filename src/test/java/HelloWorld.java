import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

    public static WebDriver driver;

    @Before
    public void setUp(){
        //chrome
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        //System.setProperty("webdriver.gecko.driver","./drivers/gecko");
        driver = new ChromeDriver();
        driver.get("http://www.thoughtworks.com");

        //firefox

        //headless (phantomjs)
        
    }

    @Test
    public void checkBrowser(){

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}