package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageBase {

    WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver=driver;
    }
    public PageBase scroll_down(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        return this;
    }
}
