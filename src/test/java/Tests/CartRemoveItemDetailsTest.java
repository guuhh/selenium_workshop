package Tests;

import Setup.SetupBeforeMyCart;
import org.junit.Test;

import static Urls.BasePage.LINK_NAME_ADD_CART;
import static Urls.BasePage.LINK_NAME_CONTINUE_SHOPPING;
import static org.junit.Assert.*;

/**
 * Created by grodrigu on 08/05/17.
 */
public class CartRemoveItemDetailsTest extends SetupBeforeMyCart {


    private String expectFirstBookTitle;
    private String expectSecondBookTitle;
    private String expectEmptyCartMessage;

    int indexFirstBook = 2;
    int indexSecondBook = 3;

    @Test
    public void shouldRemoveOnlyFirstBookWithSuccessful(){

        //given
        expectFirstBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";
        expectSecondBookTitle = "Programming Ruby 1.9: The Pragmatic Programmers' Guide (Facets of Ruby)";

        home.clickOnBook(driver, expectFirstBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        mycart.clickOnLinkContinue(driver, LINK_NAME_CONTINUE_SHOPPING);
        home.clickOnBook(driver, expectSecondBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);


        String firstBookTitle = mycart.getBookTitleOnMyCart(driver, indexFirstBook);
        String secondBookTitle =   mycart.getBookTitleOnMyCart(driver, indexSecondBook);

        assertEquals(expectFirstBookTitle, firstBookTitle);
        assertEquals(expectSecondBookTitle, secondBookTitle);

        //when
        mycart.clickOnLinkRemover(driver);

        //then
        firstBookTitle = mycart.getBookTitleOnMyCart(driver, indexFirstBook);

        assertFalse(firstBookTitle.contains(expectFirstBookTitle));
        assertEquals(expectSecondBookTitle, secondBookTitle);
    }

    @Test
    public void shouldRemoveTheTwoBookWithSuccessful(){

        //given
        expectEmptyCartMessage = "You don't have any items in your cart. ";
        expectFirstBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";
        expectSecondBookTitle = "Programming Ruby 1.9: The Pragmatic Programmers' Guide (Facets of Ruby)";

        home.clickOnBook(driver, expectFirstBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        mycart.clickOnLinkContinue(driver, LINK_NAME_CONTINUE_SHOPPING);
        home.clickOnBook(driver, expectSecondBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);


        String firstBookTitle = mycart.getBookTitleOnMyCart(driver, indexFirstBook);
        String secondBookTitle =   mycart.getBookTitleOnMyCart(driver, indexSecondBook);

        assertEquals(expectFirstBookTitle, firstBookTitle);
        assertEquals(expectSecondBookTitle, secondBookTitle);

        //when
        mycart.clickOnLinkRemover(driver);
        mycart.clickOnLinkRemover(driver);

        String emptyCartMessage = mycart.getEmptyMyCart(driver);

        //then
        assertTrue(emptyCartMessage.contains(expectEmptyCartMessage));

    }
}
