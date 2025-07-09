package Tests;

import freemarker.template.SimpleDate;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public  String captureScreenshot(String tname){
        Date datenow=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd,hhmmss");
        String timestamp=formatter.format(datenow);
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String screenshotDir=System.getProperty("user.dir")+"/target/screenshots/";
        new File(screenshotDir).mkdirs();
        String screenshotPath=screenshotDir+tname+"_"+timestamp+".png";

        File targetFile=new File(screenshotPath);
        sourceFile.renameTo(targetFile);
        return  screenshotPath;


    }
}
