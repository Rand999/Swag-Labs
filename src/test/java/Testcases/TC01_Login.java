package Testcases;

import Pages.P01_LoginPage;
import org.testng.annotations.Test;

public class TC01_Login extends TestBase{

    // define test data
  static  String user = "standard_user";
  static String password = "secret_sauce";

    // check login positive scenarios
    @Test(priority = 1, description = "Login with Valid Username and Password")
    public void loginWithValidData_P() {
        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();
    }

    @Test(priority = 2, description = "Login with Invalid Username ")
    public void loginWithInvalidUserName_N() {
        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();
    }

    @Test(priority = 3, description = "Login with Invalid Password")
    public void loginWithInvalidPassword_N() {
        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();
    }

    @Test(priority = 4, description = "Login with Invalid email and Password")
    public void loginWithValidData_N() {
        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();
    }
}
