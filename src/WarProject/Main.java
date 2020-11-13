package WarProject;

import java.util.Scanner;

/**
 * This is the main class of the project. The vision for this class was to act
 * as a portal/point of entry for a user. The code in this project is modeled
 * to be extendable, other card games can be created with only addition of the 
 * required game logic.
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public class Main {

    public static void main(String[] args) {

        War war = new War();

        System.out.print("[Player One]"
                + "\n1. Log In"
                + "\n2. Sign Up"
                + "\nEnter option '1' or '2': ");

        boolean portal = false;
        
        Scanner in = new Scanner(System.in);
        
        do {
            String choice = in.next();
            if (isNumeric(choice)) {
                if (Integer.parseInt(choice) == 1 || Integer.parseInt(choice) == 2) {
                    int logOrSign = Integer.parseInt(choice);
                    switch (logOrSign) {
                        case 1:
                            war.logIn();
                            portal = true;
                            break;
                        case 2:
                            war.signUp();
                            portal = true;
                            break;
                    }
                } else {
                    System.out.println("Invalid Entry: Please enter either '1' or '2'");
                }
            } else {
                System.out.println("Invalid Entry: Please enter a number");
            }
        } while (portal == false);

        System.out.println("[Player Two]");
        System.out.println("1. Log In");
        System.out.println("2. Sign Up");
        System.out.println("Enter option '1' or '2': ");

        boolean portal_2 = false;

        do {
            String choice1 = in.next();
            if (isNumeric(choice1)) {
                if (Integer.parseInt(choice1) == 1 || Integer.parseInt(choice1) == 2) {

                    int logOrSign = Integer.parseInt(choice1);
                    switch (logOrSign) {
                        case 1:
                            war.logIn();
                            portal_2 = true;
                            break;
                        case 2:
                            war.signUp();
                            portal_2 = true;
                            break;
                    }
                } else {
                    System.out.println("Invalid Entry: Please enter either '1' or '2'");
                }
            } else {
                System.out.println("Invalid Entry: Please enter a number");
            }
        } while (portal_2 == false);

        war.play();

    } //END OF MAIN METHOD

    public static boolean isNumeric(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

    