package Tests;

import Setup.Setup;
import org.junit.BeforeClass;
import org.junit.Test;

import static PageActions.LoginPage.ID_MESSAGE_LOGED_SUCESS;
import static Urls.BasePage.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by grodrigu on 27/04/17.
 */

public class LoginDetailsTest extends Setup {

    private String textName;
    private String textEmail;
    private String textPassword;

    @BeforeClass
    public void backGround(){
        //given
        String textName = "Cicrano Silva";
        String textEmail = "cicranotest123@test.com";
        String textPassword = "Alpok876˜";
        String textConfPassword = "Alpok876˜";

        //when
        home.clickOnLinkSignUp(driver, LINK_NAME_SINGUP);
        signup.fillName(driver, textName);
        signup.fillEmail(driver, textEmail);
        signup.fillPassword(driver, textPassword);
        signup.fillConfPassword(driver, textConfPassword);
        signup.clickButtonSigUp(driver);
        home.clickOnLinkLogout(driver, LINK_NAME_LOGOUT);

    }
    @Test
    public void shouldLogedWithSucessfulUsingName() {

        //given
        textName = "Cicrano Silva";
        textPassword = "Alpok876˜";

        //when
        home.clickOnLinkLogin(driver, LINK_NAME_LOGIN);
        login.fillLoginName(driver, textName);
        login.fillLoginPassword(driver, textPassword);
        login.clickButtonLogin(driver);
        String message = login.getMessage(driver, ID_MESSAGE_LOGED_SUCESS);
        //then
        assertTrue(message.contains(textName));

    }

    @Test
    public void shouldLogedWithSucessfulUsingEmail() {

        //given
        textEmail = "cicranotest123@test.com";
        textPassword = "Alpok876˜";
        textName = "Cicrano Silva";

        //when
        home.clickOnLinkLogin(driver, LINK_NAME_LOGIN);
        login.fillLoginName(driver, textEmail);
        login.fillLoginPassword(driver, textPassword);
        login.clickButtonLogin(driver);
        String message = login.getMessage(driver, ID_MESSAGE_LOGED_SUCESS);

        //then
        assertTrue(message.contains(textName));
    }
}
