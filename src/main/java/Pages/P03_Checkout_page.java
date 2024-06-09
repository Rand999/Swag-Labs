package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_Checkout_page {

    WebDriver driver;

    public P03_Checkout_page(WebDriver driver) {
        this.driver = driver;
    }


    private final By CART_LINK = By.xpath("//a[@href='./cart.html']");

    private final By CHECKOUT_BUTTON = By.xpath("//a[@href='./checkout-step-one.html']");
    private final By FIRST_NAME = By.xpath("//input[@id='first-name']");

    private final By LAST_NAME = By.xpath("//input[@id='last-name']");

    private final By CODE = By.xpath("//input[@id='postal-code']");

    private final By CONTIUE = By.xpath("//input[@value='CONTINUE']");

  //  private final By TOTAL_PRICE = By.xpath("//input[@value='CONTINUE']");
    private final By FINISH = By.xpath("//a[@href='./checkout-complete.html']");


    //assert under checkout page
    WebElement  ITEM_TOTAL = null;
    WebElement  TAX = null;
    WebElement TOTAL = null;


    public P03_Checkout_page click_Cart_Icon() {
        driver.findElement(this.CART_LINK).click();
        return this;
    }

    public P03_Checkout_page click_checkout_button() {
        driver.findElement(this.CHECKOUT_BUTTON).click();
        return this;
    }

    public P03_Checkout_page First_name(String Fname) {
        driver.findElement(this.FIRST_NAME).sendKeys(Fname);
        return this;
    }

    public P03_Checkout_page Last_name(String Lname) {
        driver.findElement(this.LAST_NAME).sendKeys(Lname);
        return this;
    }

    public P03_Checkout_page Fill_code(String code) {
        driver.findElement(this.CODE).sendKeys(code);
        return this;
    }

    public P03_Checkout_page Click_contiue_button() {
        driver.findElement(this.CONTIUE).click();
        return this;
    }

    public P03_Checkout_page Click_finish_button() {
        driver.findElement(this.FINISH).click();
        return this;
    }

public double Assumption_Of_itemtotal_plus_tax(){
    ITEM_TOTAL = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
      String priceText = ITEM_TOTAL.getText().trim().replaceAll("[^\\d.]", "");
      double price_item = Double.parseDouble(priceText);
      System.out.println("The items total is : "+ price_item);


    TAX = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
    String taxText = TAX.getText().trim().replaceAll("[^\\d.]", "");
    double tax_item = Double.parseDouble(taxText);
    System.out.println("The tax is : " +tax_item);

    double TOTAL_WITH_TAX = price_item + tax_item ;
    System.out.println("The summation with the tax  "+TOTAL_WITH_TAX);
    return TOTAL_WITH_TAX ;
}

public double GET_TOTAL(){
    TOTAL = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
    String totalText = TOTAL.getText().trim().replaceAll("[^\\d.]", "");
    double total_item = Double.parseDouble(totalText);

    //double randomVariation = Math.random() * 0.1 - 0.05;
    //double finalTotalPrice = total_item + randomVariation;

    System.out.println("Total is : "+total_item);
    return total_item;
}

}
