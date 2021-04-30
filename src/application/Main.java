package application;

import controller.AtmController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AtmController refController = new AtmController(); // initialize controller reference
        Scanner refScanner = new Scanner(System.in);
        boolean sessionActive = true; // always be true until the user logout.

        while(sessionActive) { // will always run this loop while sessionActive is true
            try {
                System.out.println("\n User Home Page: \n 1) Register \n 2) Login \n 3) Forget Password \n 4) Logout \n");
                System.out.println("Enter you choice: ");

                int userChoice = refScanner.nextInt();

                if (userChoice == 1) {
                    refController.callRegisterService(); // call register service in controller
                } else if (userChoice == 2) {
                    refController.callLoginService(); // call login service in controller
                } else if (userChoice == 3) {
                    refController.callResetService(); // call reset service in controller
                } else if (userChoice == 4) {
                    sessionActive = false; // to stop from running this while loop
                    System.out.println("\n Logout Successful! Thank you for banking with us.");
                } else { // for inputs other than 1-4
                    throw new Exception("Invalid input!!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
