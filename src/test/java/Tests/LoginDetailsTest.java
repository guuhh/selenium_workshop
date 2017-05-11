package Tests;

import PageActions.HomePage;
import PageActions.SignupPage;
import Setup.Setup;
import org.junit.Before;
import org.junit.Test;

import static PageActions.SignupPage.ID_MESSAGE_SIGNED_SUCESS;
import static Urls.BasePage.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by grodrigu on 27/04/17.
 */

public class LoginDetailsTest extends Setup {

    private String textName;
    private String textEmail;
    private String textPassword;

    @Before
    public void setupLoginDetails(){
        //given
        String textName = "Cicrano Silva";
        String textEmail = "cicranotest123@test.com";
        String textPassword = "Alpok876˜";
        String textConfPassword = "Alpok876˜";

        //when
        HomePage homeToLoginScenario = new HomePage();
        SignupPage signupToLoginScenario = new SignupPage();

        homeToLoginScenario.clickOnLinkSignUp(driver, LINK_NAME_SINGUP);
        signupToLoginScenario.fillName(driver, textName);
        signupToLoginScenario.fillEmail(driver, textEmail);
        signupToLoginScenario.fillPassword(driver, textPassword);
        signupToLoginScenario.fillConfPassword(driver, textConfPassword);
        signupToLoginScenario.clickButtonSigUp(driver);
        homeToLoginScenario.clickOnLinkLogout(driver, LINK_NAME_LOGOUT);

    }

    @Test
    public void shouldLogedWithSuccessfulUsingName() {

        //given
        textName = "Cicrano Silva";
        textPassword = "Alpok876˜";

        //when
        home.clickOnLinkLogin(driver, LINK_NAME_LOGIN);
        login.fillLoginName(driver, textName);
        login.fillLoginPassword(driver, textPassword);
        login.clickButtonLogin(driver);
        String message = login.getMessage(driver, ID_MESSAGE_SIGNED_SUCESS);
        //then
        assertTrue(message.contains(textName));

    }

    @Test
    public void shouldLogedWithSuccessfulUsingEmail() {

        //given
        textEmail = "cicranotest123@test.com";
        textPassword = "Alpok876˜";
        textName = "Cicrano Silva";

        //when
        home.clickOnLinkLogin(driver, LINK_NAME_LOGIN);
        login.fillLoginName(driver, textEmail);
        login.fillLoginPassword(driver, textPassword);
        login.clickButtonLogin(driver);

        String message = login.getMessage(driver, ID_MESSAGE_SIGNED_SUCESS);

        //then
        assertTrue(message.contains(textName));
    }
}
