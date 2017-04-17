package Controlers;

import Models.HomePageDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by grodrigu on 17/04/17.
 */
public class UIElement {

    private WebDriver driver;
    private String id;
    private WebDriverWait wait;

    public UIElement(WebDriver drive, String id){
        this.driver = drive;
        this.id = id;
        this.wait = new WebDriverWait(this.driver, 15);
    }

    public UIElement(WebDriver drive){
        this.driver = drive;
        this.wait = new WebDriverWait(this.driver, 15);
    }

    public WebElement findElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return this.driver.findElement(By.id(id));
    }

    public WebElement findMessage(){
        wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.id(id))));
        return this.driver.findElement(By.id(id));

    }
    public WebDriver findTitle(){
        wait.until(ExpectedConditions.titleIs(String.valueOf(HomePageDetails.VALID_TITLE.getHomeTitle())));
        return this.driver;
    }
}
