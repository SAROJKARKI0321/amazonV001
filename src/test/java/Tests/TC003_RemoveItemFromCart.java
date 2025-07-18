package Tests;

import Pages.HomePage;
import Pages.MyCart;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_RemoveItemFromCart extends BaseTest{


    @Test
    public void checkIsCartEmpty(){
        HomePage homePage=new HomePage(driver);
        homePage.goToMyCart();
        MyCart myCart=new MyCart(driver);
        myCart.removeItemsFromCart();
        Assert.assertTrue(myCart.isEmpty());

    }
}
