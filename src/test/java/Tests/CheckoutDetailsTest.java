package Tests;

import Setup.SetupBeforeMyCart;
import org.junit.Test;

import static Urls.BasePage.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by grodrigu on 09/05/17.
 */
public class CheckoutDetailsTest extends SetupBeforeMyCart {

    private String logedName;
    private String totalOrder;
    private String expectFirstBookTitle;
    private String expectSecondBookTitle;

    @Test
    public void shouldCheckedIfOrderValueIsFinalizedWithSuccessful() {

        //given
        logedName = "Beltrano Dutra";
        expectFirstBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";
        expectSecondBookTitle = "Programming Ruby 1.9: The Pragmatic Programmers' Guide (Facets of Ruby)";

        //when
        home.clickOnBook(driver, expectFirstBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        mycart.clickOnLinkContinue(driver, LINK_NAME_CONTINUE_SHOPPING);
        home.clickOnBook(driver, expectSecondBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        totalOrder = mycart.getTotalValueChecked();
        mycart.clickOnCheckout(driver);
        home.clickOnLinkAdminUI(driver, LINK_NAME_ADMIN_INTERFACE);
        dash.clickOnLinkOrders(driver);
        String lastRowInformation = order.getLastRowInformation(driver);

        //then
        assertTrue(lastRowInformation.contains(logedName));
        assertTrue(lastRowInformation.contains(totalOrder));

    }

    @Test
    public void shouldCheckedIfOrderValueIsMoreThanZeroToSucessful() {

        //given
        logedName = "Beltrano Dutra";
        expectFirstBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";
        expectSecondBookTitle = "Programming Ruby 1.9: The Pragmatic Programmers' Guide (Facets of Ruby)";

        //when
        home.clickOnBook(driver, expectFirstBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        mycart.clickOnLinkContinue(driver, LINK_NAME_CONTINUE_SHOPPING);
        home.clickOnBook(driver, expectSecondBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        mycart.clickOnLinkRemover(driver);
        mycart.clickOnLinkRemover(driver);
        totalOrder = mycart.getTotalValueChecked();
        mycart.clickOnCheckout(driver);


        totalOrder = totalOrder.substring(1);
        Double doubleOrderValue = Double.parseDouble(totalOrder);
        Math.round(doubleOrderValue);
        Double minDoubleValid = Double.MIN_VALUE;

        //then
        assertTrue(doubleOrderValue.equals(minDoubleValid));


    }

    }
