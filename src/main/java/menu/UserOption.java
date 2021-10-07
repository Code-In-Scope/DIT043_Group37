package menu;

import facade.Facade;
import util.UserInput;

public class UserOption {
    Facade item;

    UserOption(){
        item = new Facade();
    }

    public static void mainOptionMenu(){
        int startingOption = 0;
        int endingOption = 2;
        int userOption;
        Facade item = new Facade();

        do {
            userOption = UserInput.getInputInt("Type an option number: ");
            switch (userOption){
                case 0: break;
                case 1: break;
                case 2: break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption < startingOption || userOption > endingOption);
    }
    public void itemOptionMenu(){
        int startingOption = 0;
        int endingOption = 6;
        int userOption;
        do {
            userOption = UserInput.getInputInt("Type an option number: ");
            switch (userOption){
                case 0: break;
                case 1:
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption < startingOption || userOption > endingOption);
    }
    public static void reviewOptionMenu(){
        int startingOption = 0;
        int endingOption = 10;
        int userOption;
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
