package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends  BasePage{

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//h2[@aria-label='AirPods 4 Wireless Earbuds, Bluetooth Headphones, with Active Noise Cancellation, Adaptive Audio, Transparency Mode, Personalized Spatial Audio, USB-C Charging Case, Wireless Charging, H2 Chip']//span[contains(text(),'AirPods 4 Wireless Earbuds, Bluetooth Headphones,')]")
    WebElement topProduct;

 /*   @FindBy(xpath="//div[@id='newAccordionRow_1']//div[@role='button']")
    WebElement regularpricepay;
*/
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//span[@class='nav-line-2'][normalize-space()='Cart']")
    WebElement btnSeeyourCart;

  /*  @FindBy(xpath = "//span[@class='a-truncate-full' and contains(text(),'Samsung Galaxy S25 Ultra, 512G')] ")
    WebElement cartItem;*/



    



    //action
    public  void addItemTOcart(){
        waitforClickbility(topProduct);
        logger.info("Selecting the first product");
        topProduct.click();
       /* waitforvisiivlity(regularpricepay);
        regularpricepay.click();*/
        logger.info("Adding to cart");
        waitforClickbility(btnAddToCart);
        btnAddToCart.click();
        WebElement btnnoProtectionPlan=driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']"));
        waitforvisiivlity(btnnoProtectionPlan);
        btnnoProtectionPlan.click();
        logger.info("Added items to the cart ");


    }

public Boolean checkyouritem(){
        Boolean isVis=driver.findElement(By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']//h1")).isDisplayed();
        return isVis;

    }
}
