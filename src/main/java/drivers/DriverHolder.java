package drivers;

import org.openqa.selenium.WebDriver;

public class DriverHolder {

    private final static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return driver.get();
    }
    public static void setDriver(WebDriver driver){
        DriverHolder.driver.set(driver);
    }



}
