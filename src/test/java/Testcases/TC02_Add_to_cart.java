package Testcases;

import Pages.P01_LoginPage;
import Pages.P02_Add_to_cart_page;
import Pages.P03_Checkout_page;
import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


//import static Pages.P02_Add_to_cart_page.totalPrice;
import static Pages.P02_Add_to_cart_page.totalPrice;
import static Testcases.TC01_Login.password;
import static Testcases.TC01_Login.user;
import static Utility.Utilities.*;

public class TC02_Add_to_cart extends TestBase {
    // static double totalPrice = 0.0;
    @Test(priority = 5, description = "Adding random products depends on random number of item should add , in addition to calculate the total price")
    public void addRandomProduct_P() throws InterruptedException {


        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();
        Thread.sleep(1000);
        new P02_Add_to_cart_page(driver).add_Random_Product();
        new P03_Checkout_page(driver).click_Cart_Icon().click_checkout_button().First_name(RandomFirstName()).Last_name(RandomLirstName()).Fill_code(getRandomNumberString()).Click_contiue_button();
        new PageBase(driver).scroll_down();
        //Assert.assertEquals(new P03_Checkout_page(driver).Assumption_Of_itemtotal_plus_tax(),new P02_Add_to_cart_page(driver).retrive_Total_Price_Of_The_Cart());
        Assert.assertEquals(new P03_Checkout_page(driver).Assumption_Of_itemtotal_plus_tax(),new P03_Checkout_page(driver).GET_TOTAL());

        //new P03_Checkout_page(driver).GET_TOTAL()
    }



}




