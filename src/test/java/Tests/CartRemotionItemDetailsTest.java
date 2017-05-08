package Tests;

import PageActions.BookDetails;
import PageActions.HomePage;
import PageActions.MyCartPage;
import PageActions.SignupPage;
import Setup.Setup;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static Urls.BasePage.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by grodrigu on 08/05/17.
 */
public class CartRemotionItemDetailsTest extends Setup {


    private String expectFirstBookTitle;
    private String expectSecondBookTitle;
    private String empityCartMessage;


    @Before
    public void setupCartRemotionItemDetails(){
        //given
        String textName = "Beltrano Dutra";
        String textEmail = "beltranotest123@test.com";
        String textPassword = "Warvk092!";
        String textConfPassword = "Warvk092!";

        //when
        HomePage homeToRemotionCart = new HomePage();
        SignupPage signupToRemotionCart = new SignupPage();
        BookDetails bookToRemotionCart = new BookDetails();
        MyCartPage mycart = new MyCartPage();

        homeToRemotionCart.clickOnLinkSignUp(driver, LINK_NAME_SINGUP);

        signupToRemotionCart.fillName(driver, textName);
        signupToRemotionCart.fillEmail(driver, textEmail);
        signupToRemotionCart.fillPassword(driver, textPassword);
        signupToRemotionCart.fillConfPassword(driver, textConfPassword);
        signupToRemotionCart.clickButtonSigUp(driver);

    }

    @Test
    public void shouldRemoveOnlyFirstBookithSuccessful(){


        //given
        expectFirstBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";
        expectSecondBookTitle = "Programming Ruby 1.9: The Pragmatic Programmers' Guide (Facets of Ruby)";

        home.clickOnBook(driver, expectFirstBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        mycart.clickOnLinkContinue(driver, LINK_NAME_CONTINUE_SHOPPING);
        home.clickOnBook(driver, expectSecondBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);

        By firstProductTitle = By.xpath("//*[@id=\"container\"]/table/tbody/tr[2]/td[1]");
        By secondProductTitle = By.xpath("//*[@id=\"container\"]/table/tbody/tr[3]/td[1]");

        String firstBookTitle = mycart.getBookTitleOnMyCart(driver, firstProductTitle);
        String secondBookTitle =   mycart.getBookTitleOnMyCart(driver, secondProductTitle);

        assertEquals(expectFirstBookTitle, firstBookTitle);
        assertEquals(expectSecondBookTitle, secondBookTitle);

        //when
        By firstRemoveLink = By.xpath("//*[@id=\"container\"]/table/tbody/tr[2]/td[3]/a");
        mycart.clickOnLinkRemover(driver, firstRemoveLink);

        //then
        firstBookTitle = mycart.getBookTitleOnMyCart(driver, firstProductTitle);

        assertFalse(firstBookTitle.contains(expectFirstBookTitle));
        assertEquals(expectSecondBookTitle, secondBookTitle);
    }

    @Test
    public void shouldRemoveTheTwoBookithSuccessful(){

        empityCartMessage = "You don't have any items in your cart. ";

        //given
        expectFirstBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                "(Pragmatic Programmers)";
        expectSecondBookTitle = "Programming Ruby 1.9: The Pragmatic Programmers' Guide (Facets of Ruby)";

        home.clickOnBook(driver, expectFirstBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);
        mycart.clickOnLinkContinue(driver, LINK_NAME_CONTINUE_SHOPPING);
        home.clickOnBook(driver, expectSecondBookTitle);
        bookDet.clickOnAddOnCart(driver, LINK_NAME_ADD_CART);

        By firstProductTitle = By.xpath("//*[@id=\"container\"]/table/tbody/tr[2]/td[1]");
        By secondProductTitle = By.xpath("//*[@id=\"container\"]/table/tbody/tr[3]/td[1]");

        String firstBookTitle = mycart.getBookTitleOnMyCart(driver, firstProductTitle);
        String secondBookTitle =   mycart.getBookTitleOnMyCart(driver, secondProductTitle);

        assertEquals(expectFirstBookTitle, firstBookTitle);
        assertEquals(expectSecondBookTitle, secondBookTitle);

        //when
        By firstRemoveLink = By.xpath("//*[@id=\"container\"]/table/tbody/tr[2]/td[3]/a");
        //By secondRemoveLink = By.xpath("//*[@id=\"container\"]/table/tbody/tr[3]/td[3]/a");
        mycart.clickOnLinkRemover(driver, firstRemoveLink);
        mycart.clickOnLinkRemover(driver, firstRemoveLink);

        //then
        By EmptyCartText = By.xpath("//*[@id=\"container\"]/p");

        String emptyCartMessage = mycart.getBookTitleOnMyCart(driver, EmptyCartText);
        System.out.print(emptyCartMessage);

        assertTrue(empityCartMessage.contentEquals(empityCartMessage));

    }
}
