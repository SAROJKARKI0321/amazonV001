package Tests;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC001_LoginTest extends  BaseTest {



    @Test(groups = "initial")
    public   void verifyLoginStatus(){
        WebElement welcomeSign=driver.findElement(By.xpath("//div[@id='nav-link-accountList']//span[contains(text(),'Hello')]"));
        Assert.assertEquals(welcomeSign.getText(),"Hello, Saroj");



        String path=captureScreenshot("Sucessful Login");







    }





}
