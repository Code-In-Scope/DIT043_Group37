package menu;

import util.UserInput;

public class ReviewMenu {
    private static String s = System.lineSeparator();
    public static void displayOptionMenu(){
        System.out.print("Reviews Option's Menu: "+ s +
                "0. Return to Main menu. " + s +
                "1. Create a review for an Item." + s +
                "2. Print a specific review of an Item." + s +
                "3. Print all reviews of an Item." + s +
                "4. Print mean grade of an Item." + s +
                "5. Print all comments of an Item." + s +
                "6. Print all registered reviews." + s +
                "7. Print item(s) with most reviews." + s +
                "8. Print item(s) with least reviews." + s +
                "9. Print item(s) with best mean review grade." + s +
                "10. Print item(s) with worst mean review grade." + s +
                "");
    }

    public static void getReviewOptionMenu(){
        int userOption;
        int startingOption = 0;
        int endingOption = 10;
        displayOptionMenu();
        do {
            userOption = UserInput.getInputInt("Type an option number: ");
            switch (userOption){
                case 0: break;
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                case 9: break;
                case 10: break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption < startingOption || userOption > endingOption);
    }
}
