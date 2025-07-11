package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends  BasePage{

    public SignInPage(WebDriver driver){
        super(driver);


    }

    //locators
    @FindBy(xpath = "//input[@id='ap_email_login']")
    WebElement inputEmail;

    @FindBy(xpath = "//span[@id='continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement inputPassword;

    @FindBy (xpath = "//input[@id='signInSubmit']")
    WebElement btnSignin;

    //actions
    public void enterEmail(){
        waitforvisiivlity(inputEmail);
        inputEmail.sendKeys(System.getProperty("username"));
        btnContinue.click();


    }
    public  void enterPassword() throws InterruptedException {
        waitforvisiivlity(inputPassword);
        inputPassword.sendKeys(System.getProperty("password"));
        btnSignin.click();
        Thread.sleep(15000);
    }
    //WHILE RUNNING MVN USE COMMAND LIKE THIS
    //mvn clean test -Dusername=myemail@example.com -Dpassword=MySecret123 !OKboss ;)

}
