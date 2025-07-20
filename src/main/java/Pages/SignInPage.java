package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends  BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);


    }

    //locators
    @FindBy(xpath = "//input[@id='ap_email_login']")
    WebElement inputEmail;

    @FindBy(xpath = "//span[@id='continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement btnSignin;

    //actions
    public void enterEmail() {
        waitforvisiivlity(inputEmail);

        inputEmail.sendKeys("sarojkarkicareers@gmail.com");
      //  inputEmail.sendKeys(System.getProperty("username"));
        btnContinue.click();


    }

    public void enterPassword() throws InterruptedException {
        waitforvisiivlity(inputPassword);
        inputPassword.sendKeys("Amazon$19");
       // inputPassword.sendKeys(System.getProperty("password"));
        btnSignin.click();
        try {

            WebElement continueShopping = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space()='Continue shopping']")
            ));

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", continueShopping);

            continueShopping.click();
            logger.info("Clicked Continue shopping button.");

        } catch (TimeoutException e) {
            logger.info("Continue shopping button not visible or clickable.");
        } catch (Exception e) {
            logger.error("Error clicking Continue shopping button:", e);
        }

        //WHILE RUNNING MVN USE COMMAND LIKE THIS
        //mvn clean test -Dusername=myemail@example.com -Dpassword=MySecret123 !OKboss ;)

    }
}
