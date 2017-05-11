package Tests;

import Setup.SetupBeforeMyCart;
import org.junit.Test;

import static Urls.BasePage.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by grodrigu on 04/05/17.
 */
public class CartAdditionItemDetailsTest extends SetupBeforeMyCart {

    private String expectBookTitle;
    int indexFirstBook = 2;

    @Test
    public void shouldAddBookNotIsLoggedWithSuccessful(){

        //given
        String textName = "Beltrano Dutra";
        String textPassword = "Warvk092!";
        expectBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";

        home.clickOnLinkLogout(driver, LINK_NAME_LOGOUT);
        home.clickOnBook(driver, expectBookTitle);

        //when
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        login.fillLoginName(driver, textName);
        login.fillLoginPassword(driver, textPassword);
        login.clickButtonLogin(driver);

        String bookTitle = mycart.getBookTitleOnMyCart(driver, indexFirstBook);

        //then
        assertEquals(expectBookTitle, bookTitle);

    }

    @Test
    public void shouldAddBookIsLoggedWithSuccessful(){

        //given
        String textName = "Beltrano Dutra";
        String textPassword = "Warvk092!";
        expectBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";

        home.clickOnLinkLogout(driver, LINK_NAME_LOGOUT);
        home.clickOnLinkLogin(driver, LINK_NAME_LOGIN);
        login.fillLoginName(driver, textName);
        login.fillLoginPassword(driver, textPassword);
        login.clickButtonLogin(driver);
        home.clickOnBook(driver, expectBookTitle);

        //when
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        String bookTitle = mycart.getBookTitleOnMyCart(driver, indexFirstBook);

        //then
        assertEquals(expectBookTitle, bookTitle);

    }
}
