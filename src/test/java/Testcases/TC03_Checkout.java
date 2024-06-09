package Testcases;

import Pages.P01_LoginPage;
import Pages.P02_Add_to_cart_page;
import Pages.P03_Checkout_page;
import Pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Testcases.TC01_Login.password;
import static Testcases.TC01_Login.user;


public class TC03_Checkout extends TestBase{


    String fname = Utility.Utilities.RandomFirstName();
    String lname = Utility.Utilities.RandomLirstName();

    String code = Utility.Utilities.getRandomNumberString();


   /* @Test(priority = 1, description = "checkout then fill the information")
    public void checkoutAndFillInfo_P() throws InterruptedException {


        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();
        Thread.sleep(1000);
        new P03_Checkout_page(driver).click_Cart_Icon().click_checkout_button().First_name(fname).Last_name(lname).Fill_code(code);
        System.out.println(fname + "" + lname +" " + code);
    }*/

    @Test(priority = 7, description = "checkout then fill the information")
    public void checkOut_And_Check_TotalPrice_P() throws InterruptedException {


        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();
        new P02_Add_to_cart_page(driver).add_Random_Product();
        new P03_Checkout_page(driver).click_Cart_Icon().click_checkout_button().First_name(fname).Last_name(lname).Fill_code(code).Click_contiue_button();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        new PageBase(driver).scroll_down();
        Assert.assertEquals(new P03_Checkout_page(driver).Assumption_Of_itemtotal_plus_tax(),new P03_Checkout_page(driver).GET_TOTAL());
       // Assert.assertEquals(new P03_Checkout_page(driver).Assumption_Of_itemtotal_plus_tax(),new P03_Checkout_page(driver).GET_TOTAL());

        new P03_Checkout_page(driver).Click_finish_button();
    }

}
