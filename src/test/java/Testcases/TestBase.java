package Testcases;

import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        driver = DriverFactory.getNewInstance("");
        DriverHolder.setDriver(driver);

        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterTest
    public void tearDown() {
       // driver.quit();
       // Thread.currentThread().interrupt();
    }
}
