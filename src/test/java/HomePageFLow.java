import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

    public static WebDriver driver;

    @Before
    public void setUp(){
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