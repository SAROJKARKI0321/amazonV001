package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }
//locators
    @FindBy(xpath = "//input[@id='twotabsearchtestbox']")
    WebElement searchBox;

    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement myCart;

    @FindBy(xpath = "//span[normalize-space()='Hello, sign in']")
    WebElement btnSignIn;


    //actions
    public  void searchItems(String itemName){
        searchBox.sendKeys(itemName);
    }

    public void seeCart(){
        waitforvisiivlity(myCart);
        myCart.click();
    }
    public  void signIn(){
        waitforClickbility(btnSignIn);
        btnSignIn.click();

    }
}
