package Testcases;

import Pages.P01_LoginPage;
import Pages.P02_Add_to_cart_page;
import Pages.P03_Checkout_page;
import Pages.P04_Remove_Item_Cart_Page;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Testcases.TC01_Login.password;
import static Testcases.TC01_Login.user;
import static Utility.Utilities.*;

public class TC04_Remove_Item_Cart extends TestBase{


    @Test(priority = 10, description = "Adding random products depends on random number of item should add , in addition to calculate the total price")
    public void remove_Random_item_from_list_P() throws InterruptedException {
        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();
        Thread.sleep(1000);

       new P04_Remove_Item_Cart_Page(driver).remove_random_product();
       new P03_Checkout_page(driver).click_Cart_Icon();
      //  driver.navigate().back();
      //  new P03_Checkout_page(driver).click_Cart_Icon().click_checkout_button().First_name(RandomFirstName()).Last_name(RandomLirstName()).Fill_code(getRandomNumberString()).Click_contiue_button();




    }


}
