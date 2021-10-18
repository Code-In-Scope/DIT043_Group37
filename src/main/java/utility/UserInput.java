package utility;

import java.util.Scanner;

public class UserInput {
    public static Scanner scan = new Scanner(System.in);

    public static String getInputString(String message) {
        String userInput;
        System.out.print(message);
        userInput = scan.nextLine();
        return userInput;
    }

    public static int getInputInt(String message) {
        int userInput;
        System.out.print(message);
        userInput = scan.nextInt();
        scan.nextLine();
        return userInput;
    }

    public static double getInputDouble(String message) {
        double userInput;
        System.out.print(message);
        userInput = scan.nextDouble();
        scan.nextLine();
        return userInput;
    }
}
