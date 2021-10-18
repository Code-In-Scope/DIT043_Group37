package menu;

import utility.UserInput;

public class MainMenu {
    private static String s = System.lineSeparator();

    private static void displayOptionMenu(){
        System.out.print("Main Menu: Please choose among the options below."+ s +
                "0. Close system. " + s +
                "1. Open Item options." + s +
                "2. Open Review options." + s +
                "3. Open Transaction History option" +s +
                "4. Open Employee options" + s);
    }

    public static void getMainMenuOption(){
        int userOption;
        do {
            displayOptionMenu();
            userOption = UserInput.getInputInt("Type an option number: ");
            switch (userOption){
                case 0:
                    // Exit
                    break;
                case 1:
                    ItemMenu.getItemOption();
                    break;
                case 2:
                    ReviewMenu.getReviewOption();
                    break;
                case 3:
                    TransactionMenu.getTransactionOption();
                    break;
                case 4:
                    EmployeeMenu.getEmployeeMenuOption();
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption != 0);
    }
}
