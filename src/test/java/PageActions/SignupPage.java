    package PageActions;

    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    /**
     * Created by grodrigu on 25/04/17.
     */
    public class SignupPage extends FunctionalDetals{

        public static final String ID_USERNAME = "user_username";
        public static final String ID_EMAIL = "user_email";
        public static final String ID_PASSWORD = "user_password";
        public static final String ID_CONF_PASSWORD = "user_password_confirmation";
        public static final String NAME_BUTTON_SIGNUP = "commit";
        public static final String ID_MESSAGE_SIGNED_SUCESS =  "auth";

        private WebElement textName;
        private WebElement textEmail;
        private WebElement textPassword;
        private WebElement textConfPassword;
        private WebElement buttonSignup;


        public void fillName(WebDriver driver, String name){

            this.textName = driver.findElement(By.id(ID_USERNAME));
            this.textName.sendKeys(name);
        }


        public void fillEmail(WebDriver driver, String textEmail){

            this.textEmail = driver.findElement(By.id(ID_EMAIL));
            this.textEmail.sendKeys(textEmail);
        }


        public void fillPassword(WebDriver driver, String textPassword){

            this.textPassword = driver.findElement(By.id(ID_PASSWORD));
            this.textPassword.sendKeys(textPassword);
            //String ret = driver.findElement(By.xpath("//*[@id=\"auth\"]/text()[2]")).getAttribute("value");
        }


        public void fillConfPassword(WebDriver driver, String name){

            this.textConfPassword = driver.findElement(By.id(ID_CONF_PASSWORD));
            this.textConfPassword.sendKeys(name);
        }


        public void clickButtonSigUp(WebDriver driver){

            this.buttonSignup = driver.findElement(By.name(NAME_BUTTON_SIGNUP));
            this.buttonSignup.click();
        }

    }
