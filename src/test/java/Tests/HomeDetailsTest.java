package Tests;

import Setup.Setup;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by grodrigu on 25/04/17.
 */
public class HomeDetailsTest extends Setup {

    private String homeTitle;

    @Test
    public void shouldCheckHomeTitle(){

        //given
        homeTitle = "The Active Admin Store";

        //when
        String expectTitle = home.getTitle(driver);

        //then
        assertEquals(expectTitle, homeTitle);
    }
}
