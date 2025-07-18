package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCart  extends  BasePage{
    public MyCart (WebDriver driver){
        super(driver);
    }

    //locators
  @FindBy(xpath = "//ul[@class=\"a-unordered-list a-nostyle a-vertical a-spacing-mini sc-list-body sc-java-remote-feature\"]/div[3]//input[contains(@name, 'delete')]")

    WebElement firstitemDeleteBtn;
/*@FindBy(xpath = "//ul[@class=\"a-unordered-list a-nostyle a-vertical a-spacing-mini sc-list-body sc-java-remote-feature\"]/div[4]//input[contains(@name, 'delete')]")
    WebElement seconditemDeleteBtn;*/


//actions

    public  void removeItemsFromCart(){
        waitforClickbility(firstitemDeleteBtn);
        firstitemDeleteBtn.click();



    }
    public boolean isEmpty(){
        System.out.println(driver.findElements(By.xpath("//span[contains(@id,'removed-msg-text-delete')]")).isEmpty());
       return !driver.findElements(By.xpath("//span[contains(@id,'removed-msg-text-delete')]")).isEmpty();



    }
}
