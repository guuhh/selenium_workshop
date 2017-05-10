package Tests;

import org.junit.Test;

import static PageActions.SignupPage.ID_MESSAGE_SIGNED_SUCESS;
import static Urls.BasePage.*;

/**
 * Created by grodrigu on 09/05/17.
 */
public class CheckoutDetailsTest extends CartRemotionItemDetailsTest{

    private String expectFirstBookTitle;
    private String expectSecondBookTitle;

    @Test
    public void shouldCheckedTwoBooksWithSuccessful() {

        //given
        expectFirstBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";
        expectSecondBookTitle = "Programming Ruby 1.9: The Pragmatic Programmers' Guide (Facets of Ruby)";

        //when
        String message = login.getMessage(driver, ID_MESSAGE_SIGNED_SUCESS);
        home.clickOnBook(driver, expectFirstBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        mycart.clickOnLinkContinue(driver, LINK_NAME_CONTINUE_SHOPPING);
        home.clickOnBook(driver, expectSecondBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        String totalValue = mycart.checkTotalValue();
        mycart.clickOnCheckout(driver);
        home.clickOnLinkAdminUI(driver, LINK_NAME_ADMIN_INTERFACE);
        dash.clickOnLinkOrders(driver);

        //then
        //assertTrue(message.contains(textName));



    }



    }
