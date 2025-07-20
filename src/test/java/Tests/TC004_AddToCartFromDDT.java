package Tests;

import Pages.HomePage;
import Pages.SearchResultPage;
import Utilities.DataProviders;
import org.testng.annotations.Test;

public class TC004_AddToCartFromDDT extends BaseTest {


    @Test(dataProvider ="amazonSearchData",dataProviderClass = DataProviders.class)
    public  void  verfiyProductisAdded(String category,String product,String description) throws InterruptedException {
        HomePage page=new HomePage(driver);
        SearchResultPage searchResultPage= page.selectDepartment_andSearch(category,product);
        searchResultPage.addItemFromDDT(description);




    }

}
