package Tests;

import Setup.Setup;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grodrigu on 18/04/17.
 */
public class BookDetailsTest extends Setup {

    private String expectBookTitle;
    private String expectBookPrice;
    private String expectBookAuthor;

    @Test
    public void ShouldAccessBookDetailsPage(){
        //given
        expectBookTitle = "Seven Languages in Seven Weeks: A Pragmatic Guide to Learning Programming Languages " +
                    "(Pragmatic Programmers)";
        expectBookPrice = "Price: $23.07 (Add to Card)";
        expectBookAuthor = "By: Bruce Tate";

        //when
        home.clickOnBook(driver, expectBookTitle);
        String bookTitle = bookDet.getBookTitle(driver);
        String bookPrice = bookDet.getBookPrice(driver);
        String bookAuthor = bookDet.getBookAuthor(driver);

        //then
        Assert.assertEquals(expectBookTitle, bookTitle);
        Assert.assertEquals(expectBookPrice, bookPrice);
        Assert.assertEquals(expectBookAuthor, bookAuthor);
    }


}
