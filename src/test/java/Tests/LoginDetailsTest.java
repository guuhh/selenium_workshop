package Tests;

import Setup.Setup;
import org.junit.Test;

import static PageActions.LoginPage.ID_MESSAGE_LOGED_SUCESS;
import static Urls.URLS.LINK_NAME_LOGIN;
import static org.junit.Assert.assertTrue;

/**
 * Created by grodrigu on 27/04/17.
 */
public class LoginDetailsTest extends Setup {

    private String textName;
    private String textEmail;
    private String textPassword;

    @Test
    public void shouldLogedWithSucessfulUsingName(){

        //given
        textName = "Fulano Silva";
        textPassword = "Aklmn123@";

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
    public void shouldLogedWithSucessfulUsingEmail(){

        //given
        textEmail = "fulanotest123@test.com";
        textPassword = "Aklmn123@";
        
        textName = "Fulano Silva";

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
