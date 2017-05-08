package Tests;

import PageActions.HomePage;
import PageActions.SignupPage;
import Setup.Setup;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static Urls.BasePage.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by grodrigu on 04/05/17.
 */
public class CartAditionItemDetailsTest extends Setup {

    private String expectBookTitle;


    @Before
    public void setupCartAditionItemDetails(){
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

        homeToAditionCart.clickOnLinkLogout(driver, LINK_NAME_LOGOUT);

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
        By productTitle =  By.xpath("//*[@id=\"container\"]/table/tbody/tr[2]/td[1]");
        String bookTitle = mycart.getBookTitleOnMyCart(driver, productTitle);
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
        By productTitle =  By.xpath("//*[@id=\"container\"]/table/tbody/tr[2]/td[1]");
        String bookTitle = mycart.getBookTitleOnMyCart(driver, productTitle);
        assertEquals(expectBookTitle, bookTitle);

    }
}
