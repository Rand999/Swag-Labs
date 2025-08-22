package Testcases;

import Pages.P01_LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static Testcases.TC01_Login.password;
import static Testcases.TC01_Login.user;

public class TC05_Extract_Products_CSV extends TestBase{

    @Test(priority = 5, description = "Extract_products_To_CSV")
    public void Extract_products() {

        new P01_LoginPage(driver).inputEmail(user).inputPassword(password).clickLoginButton();

        // Generate file name with date & time
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "products_" + timestamp + ".csv";



        try {

            double totalPrice = 0.0;

            // Locate all product containers
            List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));


            FileWriter writer = new FileWriter(fileName);
            writer.append("Product Name,Price,Link\n");

            for (WebElement product : products) {
                try {


                    String name = product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();


                    String priceText = product.findElement(By.xpath(".//div[@class='inventory_item_price']")).getText();


                    String link = product.findElement(By.cssSelector("a")).getAttribute("href");


                    double price = Double.parseDouble(priceText.replace("$", "").trim());


                    totalPrice += price;

                    //System.out.println(name + " | " + price + " | " + link);


                    // Write to CSV
                    writer.append(name.replace(",", " "))
                            .append(",")
                            .append(String.valueOf(price))
                            .append(",")
                            .append(link)
                            .append("\n");

                } catch (Exception e) {
                    System.out.println("Error extracting product details: " + e.getMessage());
                }

            }
            writer.append("TOTAL,").append(String.valueOf(totalPrice)).append(",\n");
            writer.flush();
            writer.close();
            System.out.println("Data exported to products.csv");

            System.out.println(" Total Price of All Products: $" + totalPrice);
            System.out.println("✅ Data exported to " + fileName);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
