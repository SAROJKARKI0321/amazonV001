package Tests;

import Pages.HomePage;
import Pages.SearchResultPage;
import org.testng.annotations.Test;

public class TC005_FitersApplyTest extends  BaseTest{

    @Test
    public  void applyFilters() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
      SearchResultPage searchResultPage= homePage.selectDepartment_andSearch("Amazon Autos","Hyundai");
        searchResultPage.applyFiltersCars("Used","2025");
    }


}
