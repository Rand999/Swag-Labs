package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static Utility.Utilities.generateRandomItem;
import static Utility.Utilities.generateRandompoduct;

public class P04_Remove_Item_Cart_Page {

    static public double totalPrice = 0.0;
    WebDriver driver;

    public P04_Remove_Item_Cart_Page(WebDriver driver) {
        this.driver = driver;
    }


    public P04_Remove_Item_Cart_Page remove_random_product() {
        int product_number = generateRandompoduct();

        WebElement ADD_PRODUCT;
        WebElement PRICE_ELEMENT = null;
        Set<Integer> addedItems = new HashSet<>();
     //   Set<Double> addedPrices = new HashSet<>();
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
               // addedItems.add(price);
                totalPrice += price;

            } else {
                System.out.println("Item " + item_number + " already added to cart!");
                i=i-1;
            }

            System.out.println("----------------------------- ADDING PRODUCT " + i + "  OF  " + product_number);

            System.out.println(" Product ID:  " + item_number + "  Product price : " + price);
            System.out.println("Total price of unique items: " + totalPrice);
            System.out.println(addedItems);

        }
        System.out.println("Number of Products added " + product_number);
        //remove element
        // **Remove a random item after the loop**
        if (addedItems.size() > 0) {
            Random random = new Random();

            // Convert Set to ArrayList for random access (consider alternative approaches if Set is essential)
            List<Integer> itemList = new ArrayList<>(addedItems);

            int indexToRemove = random.nextInt(itemList.size());
            int removedItem = itemList.get(indexToRemove);

            // Remove the item from the original Set
            addedItems.remove(removedItem);

            System.out.println("Removed random item: " + removedItem);

            String priceText = PRICE_ELEMENT.getText().trim().replaceAll("[^\\d.]", "");
            double removedItemPrice = Double.parseDouble(priceText);

            totalPrice -= removedItemPrice;

            System.out.println("Removed random item: " + removedItem + " (price: $" + removedItemPrice + ")");

            // ... (code for removing the item from the GUI  (ask)
        } else {
            System.out.println("No items added to remove.");
        }
System.out.println(" THE FINAL TOTAL (removed item price) "+totalPrice);
        return this;

    }
}




