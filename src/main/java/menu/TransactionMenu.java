package menu;

import facade.Facade;
import util.UserInput;

public class TransactionMenu {
    private static final String s = System.lineSeparator();
    private static final Facade facade = new Facade();


    private static void displayOptionMenu(){
        System.out.println("Transaction History options menu: " + s +
                "0. Return to Main Menu." + s +
                "1. Print total profit from all item purchases." + s +
                "2. Print total units sold from all item purchases" + s +
                "3. Print the total number of item transactions made." + s +
                "4. Print all transactions made." + s +
                "5. Print the total profit of a specific item." + s +
                "6. Print the number of units sold of a specific item." + s +
                "7. Print all transactions of a specific item." + s +
                "8. Print item with highest profit." + s );
    }

    public static void getTransactionOption(){
        displayOptionMenu();
        int userOption;
        do {
            userOption = UserInput.getInputInt("Type an option number: ");

            switch (userOption){
                case 0:
                    //Exit
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    printItemTransaction();
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption != 0);
    }

    public static void printItemTransaction(){
        String itemID = UserInput.getInputString("Enter item ID to print all transactions: ");
        String printTransaction = facade.printItemTransactions(itemID);
        System.out.println(printTransaction);
    }


}
