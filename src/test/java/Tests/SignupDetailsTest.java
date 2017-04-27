package Tests;

import Setup.Setup;
import org.junit.Test;

import static PageActions.SignupPage.*;
import static Urls.URLS.LINK_NAME_SINGUP;
import static org.junit.Assert.*;

/**
 * Created by grodrigu on 25/04/17.
 */
public class SignupDetailsTest extends Setup {

    private String textName;
    private String textEmail;
    private String textPassword;
    private String textConfPassword;

    @Test
    public void shouldSignUPWithSucessful(){

        //given
        textName = "Fulano Silva";
        textEmail = "fulanotest123@test.com";
        textPassword = "Aklmn123@";
        textConfPassword = "Aklmn123@";

        //when
        home.clickOnLinkSignUp(driver, LINK_NAME_SINGUP);
        signup.fillName(driver, textName);
        signup.fillEmail(driver, textEmail);
        signup.fillPassword(driver, textPassword);
        signup.fillConfPassword(driver, textConfPassword);
        signup.clickButtonSigUp(driver);
        String message = signup.getMessage(driver, ID_MESSAGE_SIGNED_SUCESS);

        //then
        assertTrue(message.contains(textName));
    }
}
