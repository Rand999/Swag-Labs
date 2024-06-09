package Utility;

import java.util.Random;

public class Utilities {


    // generate random FName

    public static String RandomFirstName() {
        String[] names = {"Emma", "Olivia", "Ava", "Sophia", "Isabella", "Charlotte", "Mia", "Amelia", "Evelyn", "Abigail",
                "Noah", "Liam", "William", "Mason", "James", "Benjamin", "Aiden", "Lucas", "Logan", "Elijah"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }



    // generate random FLame
    public static String RandomLirstName() {
        String[] names = {"Emma", "Olivia", "Ava", "Sophia", "Isabella", "Charlotte", "Mia", "Amelia", "Evelyn", "Abigail",
                "Noah", "Liam", "William", "Mason", "James", "Benjamin", "Aiden", "Lucas", "Logan", "Elijah"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }




    //// generate random code

    public static String getRandomNumberString() {
        int length = 8;
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generate random digit between 0 and 9
            sb.append(digit);
        }
        return sb.toString();
    }

    public static int generateRandompoduct() {
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1; // Generate random int between 1 and 6
     //   return String.valueOf(randomNumber); // Convert the number to a String
          return randomNumber;
    }


    public static int generateRandomItem() {
        Random random = new Random();
        int randomitem = random.nextInt(6) + 1;
        //   return String.valueOf(randomNumber); // Convert the number to a String
        return randomitem;
    }

}
