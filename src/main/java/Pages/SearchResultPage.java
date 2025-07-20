package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public  void addItemFromDDT(String desc) throws InterruptedException {
      WebElement item=  driver.findElement(By.xpath(""+desc+""));
      waitforvisiivlity(item);
      item.click();
        logger.info("Adding to cart");
        waitforClickbility(btnAddToCart);
        btnAddToCart.click();
        Thread.sleep(1000);

                 //driver.findElement(By.xpath("//span[normalize-space()='No thanks' or normalize-space()='No Thanks']")).click();
           ;


        logger.info("Added items to the cart ");


    }
    public void applyFiltersCars(String condition,String makeYear) throws InterruptedException {
       WebElement checkCondition= driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-base\"][normalize-space()='"+condition+"']"));
       checkCondition.click();
       waitforvisiivlity(driver.findElement(By.xpath("//h2[normalize-space()=\"Results\"]")));




       WebElement checkboxYear= driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-base\"][normalize-space()='"+makeYear+"']"));
       checkboxYear.click();
       Thread.sleep(2000);
        waitforvisiivlity(driver.findElement(By.xpath("//h2[normalize-space()=\"Results\"]")));

       Actions actions=new Actions(driver);

        WebElement leftSlider=driver.findElement(By.xpath("//input[@id=\"p_36/range-slider_slider-item_lower-bound-slider\" and @aria-label='Minimum price']"));
        System.out.println( "slider width:"+leftSlider.getSize().getWidth());
        WebElement rightSlider=driver.findElement(By.xpath("//input[@id=\"p_36/range-slider_slider-item_upper-bound-slider\" and @aria-label='Maximum price']"));
       // actions.clickAndHold(rightSlider).moveByOffset(-80,0).release().perform();
        WebElement BtnApplyslider=driver.findElement(By.xpath("//input[@aria-label=\"Go - Submit price range\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",leftSlider);
        actions.clickAndHold(leftSlider).moveByOffset(100,0).release().perform();
        Thread.sleep(2000);
        BtnApplyslider.click();
        waitforvisiivlity(driver.findElement(By.xpath("//h2[normalize-space()=\"Results\"]")));


    }







    }

