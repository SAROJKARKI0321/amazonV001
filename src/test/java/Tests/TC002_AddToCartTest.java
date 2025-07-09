package Tests;

import Pages.HomePage;
import Pages.SearchResultPage;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_AddToCartTest extends BaseTest{

    @Test
    public  void checkyourcart(){

        HomePage homePage=new HomePage(driver);
        homePage.searchItems(ConfigReader.getProperty("product"));
        SearchResultPage newSearchPage=new SearchResultPage(driver);
        newSearchPage.addItemTOcart();

        Assert.assertEquals(newSearchPage.checkyouritem(),true);
        String cartScreenshotpath=captureScreenshot("Cart");








    }

}
