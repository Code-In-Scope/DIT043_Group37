package menu;

import facade.Facade;
import utility.UserInput;

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
                    MainMenu.getMainMenuOption();
                    break;
                case 1:
                    reviewItem();
                    break;
                case 2:
                    specificReview();
                    break;
                case 3:
                    printAllItemsReviews();
                    break;
                case 4:
                    meanGrade();
                    break;
                case 5:
                    printItemsComments();
                    break;
                case 6:
                    printReviews();
                    break;
                case 7:
                    printItemWithMostReviews();
                    break;
                case 8:
                    printItemWithLeastReviews();
                    break;
                case 9:
                    printItemWithBestMeanGrade();
                    break;
                case 10:
                    printItemWithWorstMeanGrade();
                    break;
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

    public static void printItemsComments(){
        String itemID = UserInput.getInputString("Enter item's ID to see item's comments: ");
        String itemComments = facade.getItemCommentsPrinted(itemID);
        System.out.println(itemComments);
    }

    public static void meanGrade(){
        String itemID = UserInput.getInputString("Enter item's ID to see item's mean grade: ");
        double meanGrade = facade.getItemMeanGrade(itemID);
        System.out.println(meanGrade);
    }

    public static void specificReview(){
        String itemID = UserInput.getInputString("Enter item's ID to see a review: ");
        int reviewNumber = UserInput.getInputInt("Enter no. of the review:");
        String specificReview = facade.getPrintedItemReview(itemID, reviewNumber);
        System.out.println(specificReview);
    }

    public static void printAllItemsReviews(){
        String print;
        print = facade.printAllReviews();
        System.out.println(print);
    }

    public static void printReviews(){
        String itemID = UserInput.getInputString("Enter item's ID to see reviews: ");
        String reviews = facade.getPrintedReviews(itemID);
        System.out.println(reviews);
    }

    public static void printItemWithMostReviews(){
        String print;
        print = facade.printMostReviewedItems();
        System.out.println(print);
    }

    public static void printItemWithLeastReviews(){
        String print;
        print = facade.printLeastReviewedItems();
        System.out.println(print);
    }

    public static void printItemWithBestMeanGrade() {
        String print;
        print = facade.printBestReviewedItems();
        System.out.println(print);
    }

    public static void printItemWithWorstMeanGrade() {
        String print;
        print = facade.printWorseReviewedItems();
        System.out.println(print);
    }
}
