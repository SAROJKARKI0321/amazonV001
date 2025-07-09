package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Logger logger= LogManager.getLogger(this.getClass());


    public  BasePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }

    public  void waitforvisiivlity(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public  void waitforClickbility(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
}


