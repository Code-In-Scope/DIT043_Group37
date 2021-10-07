package menu;

import util.UserInput;

public class MainMenu {
    private static String s = System.lineSeparator();
    public static void displayOptionMenu(){
        System.out.print("Main Menu: Please choose among the options below."+ s +
                "0. Close system. " + s +
                "1. Open Item options." + s +
                "2. Open Review options." + s +
                "3. Open Transaction History option" +s +
                "");
    }
    public static void getMainMenuOption(){
        int userOption;
        int startingOption = 0;
        int endingOption = 2;
        displayOptionMenu();
        do {
            userOption = UserInput.getInputInt("Type an option number: ");
            switch (userOption){
                case 0: break;
                case 1:
                    ItemMenu.getItemOptionMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption < startingOption || userOption > endingOption);
    }
}
