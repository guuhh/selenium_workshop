package Controlers;

import org.openqa.selenium.WebDriver;

/**
 * Created by grodrigu on 17/04/17.
 */
public class Message extends UIElement{


    public Message(WebDriver driver, String id){

        super(driver, id);

    }

    public Message(WebDriver driver){

        super(driver);

    }

    public String returnTitle(){

        return findTitle().getTitle();
    }

    public String returnMessage(){

        return findMessage().getText();

    }

}
