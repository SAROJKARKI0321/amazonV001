package Tests;

import Pages.HomePage;
import Pages.SignInPage;
import freemarker.template.SimpleDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {
    protected static WebDriver driver;
    Logger logger=LogManager.getLogger(this.getClass());
    public BaseTest(){

    }

    public BaseTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @BeforeClass
    public void setUp(ITestContext context) throws InterruptedException, MalformedURLException {

      /*  ChromeOptions options=new ChromeOptions();
       options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-dev-shm-usage");
         driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);*/
        driver=new ChromeDriver();


        context.setAttribute("driver",driver);
        logger.info("Getting the driver started");


        driver.get("https://www.amazon.com/");

        logger.info("Browser started and opened amazon");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        logger.info("Logging before running tests");
        HomePage homePage=new HomePage(driver);
        homePage.signIn();
        SignInPage signInPage=new SignInPage(driver);
        signInPage.enterEmail();
        signInPage.enterPassword();
    }
    @AfterClass
    public void tearDown(){
        logger.info("Closing the broswer");
       /* driver.quit();*/
    }

    public  String captureScreenshot(String tname){
        Date datenow=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd,hhmmss");
        String timestamp=formatter.format(datenow);
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        logger.info("Trying to take the screenshot");
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String screenshotDir=System.getProperty("user.dir")+"/target/screenshots/";
        new File(screenshotDir).mkdirs();
        String screenshotPath=screenshotDir+tname+"_"+timestamp+".png";
        logger.info("Screenshot saved to a new file");

        File targetFile=new File(screenshotPath);
        sourceFile.renameTo(targetFile);
        return  screenshotPath;


    }
}
