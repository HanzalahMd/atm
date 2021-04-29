package application;

import controller.AtmController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AtmController refController = new AtmController();
        Scanner refScanner = new Scanner(System.in);
        boolean sessionActive = true;

        while(sessionActive) {
            System.out.println();
            System.out.println("User Home Page: \n 1) Register \n 2) Login \n 3) Forget Password \n 4) Logout \n");
            System.out.println("Enter you choice: ");

        int userChoice = refScanner.nextInt();

        if (userChoice == 1) {
            refController.callRegisterService();
        } else if (userChoice == 2){
            refController.callLoginService();
        } else if (userChoice == 3){
            refController.callResetService();
        } else if (userChoice == 4) {
            sessionActive = false;
            System.out.println("Logout Successful");
        }
        }
    }
}
