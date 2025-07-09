package Tests;
import Pages.*;
import org.testng.annotations.Test;


public class TC001_LoginTest extends  BaseTest {

    @Test
    public   void checklogin(){
        HomePage homePage=new HomePage(driver);
        homePage.signIn();
        SignIn signInpae=new SignIn(driver);
        signInpae.enterEmail();
        signInpae.enterPassword();

        String path=captureScreenshot("Sucessful Login");







    }





}
