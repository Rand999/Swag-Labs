package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.Set;

import static Utility.Utilities.generateRandomItem;
import static Utility.Utilities.generateRandompoduct;

public class P02_Add_to_cart_page {

  static  public double totalPrice = 0.0;
    WebDriver driver;

    public P02_Add_to_cart_page(WebDriver driver) {
        this.driver = driver;
    }



   public P02_Add_to_cart_page add_Random_Product() {
       int product_number = generateRandompoduct();

       WebElement ADD_PRODUCT = null;
       WebElement PRICE_ELEMENT = null;
       Set<Integer> addedItems = new HashSet<>(); // Use HashSet
       // double totalPrice = 0.0;
       for (int i = 1; i <= product_number; i++) {

           int item_number = generateRandomItem();

           // Check if item already added before adding it
           double price = 0.0;
           if (!addedItems.contains(item_number)) {
               ADD_PRODUCT = driver.findElement(By.xpath(" //div[@class='inventory_list']//div[" + item_number + "]//div[3]//button[1]"));

               PRICE_ELEMENT = driver.findElement(By.xpath("//div[@class='inventory_list']//div[" + item_number + "]//div[3]//div[1]"));
               String priceText = PRICE_ELEMENT.getText().trim().replaceAll("[^\\d.]", "");

               price = Double.parseDouble(priceText);

               //System.out.println(price);


               ADD_PRODUCT.click();
               addedItems.add(item_number); // Add the new item to the set
               totalPrice += price;

           } else {
               System.out.println("Item " + item_number + " already added to cart!");
               i=i-1; // loop again
           }
           System.out.println("----------------------------- ADDING PRODUCT " + i + "  OF  " + product_number);
           System.out.println(addedItems);
           System.out.println(" Product ID:  " + item_number + "  Product price : " + price);
           System.out.println("Total price of unique items: " + totalPrice);


       }
       System.out.println("Number of Products added " + product_number );
       return this;

}




    public double retrive_Total_Price_Of_The_Cart() {
        int product_number = generateRandompoduct();

        WebElement ADD_PRODUCT ;
        WebElement PRICE_ELEMENT;
        Set<Integer> addedItems = new HashSet<>(); // Use HashSet for faster lookups
        // double totalPrice = 0.0;
        for (int i = 1; i <= product_number; i++) {

            int item_number = generateRandomItem();

            // Check if item already added before adding it
            double price = 0.0;
            if (!addedItems.contains(item_number)) {
                ADD_PRODUCT = driver.findElement(By.xpath(" //div[@class='inventory_list']//div[" + item_number + "]//div[3]//button[1]"));

                PRICE_ELEMENT = driver.findElement(By.xpath("//div[@class='inventory_list']//div[" + item_number + "]//div[3]//div[1]"));
                String priceText = PRICE_ELEMENT.getText().trim().replaceAll("[^\\d.]", "");

                price = Double.parseDouble(priceText);

                //System.out.println(price);


                ADD_PRODUCT.click();
                addedItems.add(item_number); // Add the new item to the set
                totalPrice += price;

            } else {
                System.out.println("Item " + item_number + " already added to cart!");
                i=i-1; // loop again
            }



        }

        return totalPrice;

    }

}
