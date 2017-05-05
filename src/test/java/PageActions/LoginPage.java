package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by grodrigu on 27/04/17.
 */
public class LoginPage extends FunctionalDetals{

    public static final String ID_LOGIN_EMAIL = "login";
    public static final String ID_LOGIN_PASSWORD = "password";
    public static final String NAME_BUTTON_LOGIN = "commit";
    public static final String ID_MESSAGE_LOGED_SUCESS =  "auth";

    private WebElement textName;
    private WebElement textEmail;
    private WebElement textPassword;
    private WebElement buttonLogin;


    public void fillLoginName(WebDriver driver, String name){

        this.textName = driver.findElement(By.id(ID_LOGIN_EMAIL));
        this.textName.sendKeys(name);

    }


    public void fillLoginEmail(WebDriver driver, String email){

        this.textEmail = driver.findElement(By.id(ID_LOGIN_EMAIL));
        this.textEmail.sendKeys(email);

    }


    public void fillLoginPassword(WebDriver driver, String textPassword){

        this.textPassword = driver.findElement(By.id(ID_LOGIN_PASSWORD));
        this.textPassword.sendKeys(textPassword);

    }


    public void clickButtonLogin(WebDriver driver){

        this.buttonLogin = driver.findElement(By.name(NAME_BUTTON_LOGIN));
        this.buttonLogin.click();

    }


    }
