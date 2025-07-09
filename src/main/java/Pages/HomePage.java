package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }
//locators
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchBox;

    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement myCart;

    @FindBy(xpath = "//span[normalize-space()='Hello, sign in']")
    WebElement btnSignIn;


    //actions
    public  void searchItems(String itemName)
    {
        logger.info("Waiting for seach box to appear");
        logger.debug("Clicked and sending the seacrh keys");
        searchBox.sendKeys(itemName);
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
    }

    public void seeCart(){
        logger.info("Opening my Cast");
        waitforvisiivlity(myCart);
        myCart.click();
    }
    public  void signIn() throws InterruptedException {
        logger.info("Signing into the webiste with a premade account");
        waitforClickbility(btnSignIn);
        btnSignIn.click();

    }
}
