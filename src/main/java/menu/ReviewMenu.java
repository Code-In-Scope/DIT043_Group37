package menu;

import facade.Facade;
import util.UserInput;

public class ReviewMenu {
    private static final String s = System.lineSeparator();
    private static final Facade facade = new Facade();

    private static void displayOptionMenu(){
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
                "10. Print item(s) with worst mean review grade." + s + s );
    }

    public static void getReviewOption(){

        displayOptionMenu();

        int userOption;
        do {
            userOption = UserInput.getInputInt("Type an option number: ");

            switch (userOption){
                case 0:
                    //Exit
                    break;
                case 1:
                    reviewItem();
                    break;
                case 2:
                    break;
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
        }while (userOption != 0);
    }

    public static void reviewItem(){
        String itemID = UserInput.getInputString("Enter the ID of the item you want to review: ");
        String comment = UserInput.getInputString("Type your comment about the item: ");
        int grade = UserInput.getInputInt("Grade item between 1 to 5: ");
        String message = "";
        if (comment == null){
            message = facade.reviewItem(itemID,grade);
        }else {
            message = facade.reviewItem(itemID, comment, grade);
        }
        System.out.println(message);
    }

}
