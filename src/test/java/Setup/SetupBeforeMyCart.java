package Setup;

import PageActions.HomePage;
import PageActions.SignupPage;
import Urls.BasePage;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static Urls.BasePage.LINK_NAME_SINGUP;

/**
 * Created by grodrigu on 10/05/17.
 */
public class  SetupBeforeMyCart  extends Setup{

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BasePage.BASE_URL);

        //given
        String textName = "Beltrano Dutra";
        String textEmail = "beltranotest123@test.com";
        String textPassword = "Warvk092!";
        String textConfPassword = "Warvk092!";

        //when
        HomePage homeToAditionCart = new HomePage();
        SignupPage signupToAditionCart = new SignupPage();

        homeToAditionCart.clickOnLinkSignUp(driver, LINK_NAME_SINGUP);

        signupToAditionCart.fillName(driver, textName);
        signupToAditionCart.fillEmail(driver, textEmail);
        signupToAditionCart.fillPassword(driver, textPassword);
        signupToAditionCart.fillConfPassword(driver, textConfPassword);
        signupToAditionCart.clickButtonSigUp(driver);

    }
}
