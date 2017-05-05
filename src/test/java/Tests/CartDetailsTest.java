package Tests;

import PageActions.HomePage;
import PageActions.SignupPage;
import Setup.Setup;
import org.junit.Before;
import org.junit.Test;

import static Urls.BasePage.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by grodrigu on 04/05/17.
 */
public class CartDetailsTest extends Setup {

    private String expectBookTitle;


    @Before
    public void setupCartDetails(){
        //given
        String textName = "Beltrano Dutra";
        String textEmail = "beltranotest123@test.com";
        String textPassword = "Warvk092!";
        String textConfPassword = "Warvk092!";

         //when
        HomePage homeToCartScenario = new HomePage();
        SignupPage signupToCartScenario = new SignupPage();

        homeToCartScenario.clickOnLinkSignUp(driver, LINK_NAME_SINGUP);
        signupToCartScenario.fillName(driver, textName);
        signupToCartScenario.fillEmail(driver, textEmail);
        signupToCartScenario.fillPassword(driver, textPassword);
        signupToCartScenario.fillConfPassword(driver, textConfPassword);
        signupToCartScenario.clickButtonSigUp(driver);
        homeToCartScenario.clickOnLinkLogout(driver, LINK_NAME_LOGOUT);

    }

    @Test
    public void shouldAddBookNotIsLoggedWithSuccessful(){

        //given
        String textName = "Beltrano Dutra";
        String textPassword = "Warvk092!";
        expectBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";

        home.clickOnBook(driver, expectBookTitle);

        //when
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        login.fillLoginName(driver, textName);
        login.fillLoginPassword(driver, textPassword);
        login.clickButtonLogin(driver);

        //then
        String bookTitle = mycart.getBookTitleOnMyCart(driver);
        assertEquals(expectBookTitle, bookTitle);

    }

    @Test
    public void shouldAddBookIsLoggedWithSuccessful(){

        //given
        String textName = "Beltrano Dutra";
        String textPassword = "Warvk092!";
        expectBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";

        home.clickOnLinkLogin(driver, LINK_NAME_LOGIN);
        login.fillLoginName(driver, textName);
        login.fillLoginPassword(driver, textPassword);
        login.clickButtonLogin(driver);
        home.clickOnBook(driver, expectBookTitle);

        //when
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);

        //then
        String bookTitle = mycart.getBookTitleOnMyCart(driver);
        assertEquals(expectBookTitle, bookTitle);

    }
}
