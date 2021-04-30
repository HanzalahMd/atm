package service;

import dao.*;
import pojo.*;

import java.util.Scanner;

public class AtmImplementation implements AtmInterface {

    Scanner refScanner = new Scanner(System.in);
    DataAccessInterface refAccess;
    boolean isAuthenticated;

    @Override
    public void UserRegistration() {

        String userInputEmail = null;
        String userInputPassword = null;
        boolean emailValidated = false;
        boolean passwordEntered = false;
        boolean passwordValidated = false;
        boolean registrationComplete = false;

        User existingUser = new User();
        existingUser.insertData("xyz@gmail.com", "xyz", "xyz");

        while (!registrationComplete){
            try {
                while(!emailValidated) {
                    System.out.println("Enter email address: ");
                    userInputEmail = refScanner.next();

                    if (userInputEmail.equals(existingUser.getUserEmail())) {
                        throw new Exception("email already exists!!" + "\n");
                    }
                    emailValidated = true;
                } // End of while (!emailValidated) loop

                while (!passwordValidated) {
                    if(!passwordEntered) {
                        System.out.println("Enter Password: ");
                        userInputPassword = refScanner.next();
                        passwordEntered = true;
                    } else {
                        System.out.println("Retype Password: ");
                        String confirmPassword = refScanner.next();

                        if (!confirmPassword.equals(userInputPassword)) {
                            throw new Exception("Password doesn't match!!");
                        }
                        passwordValidated = true;
                    }
                } // End of while (!passwordValidated) loop

                System.out.println("What is favourite colour ?");
                String userInputKey = refScanner.next();
                System.out.println(userInputKey + " is your security key, in case if you forget your password.");

                refAccess = new DataAccessImplementation();
                refAccess.createNewUser(userInputEmail, userInputPassword, userInputKey);
                registrationComplete = true;

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } // End of while (!registrationComplete) loop
    } // End of userRegistration() method


    @Override
    public void userLogin() {

        System.out.println("Enter User Email: ");
        String userInputEmail = refScanner.next();

        System.out.println("Enter Password: ");
        String userInputPassword = refScanner.next();

        isAuthenticated = refAccess.authenticateUser(userInputEmail, userInputPassword);

        if(isAuthenticated){
            System.out.println("Login Successful!!");
            beginTransaction();
        } else {
            System.out.println("Sorry invalid credentials! Please try again. \n");
            userLogin();
        }
    }


    public void beginTransaction(){

        boolean continueTransaction = true;

        while(continueTransaction) {
            System.out.println();
            System.out.println("(1) Check Available Bank Balance " + "\n"
                    + "(2) Deposit Amount" + "\n"
                    + "(3) Withdraw Amount");

            System.out.println("Enter Your Choice: ");
            int userChoice = refScanner.nextInt();

            if (userChoice == 1) {
                refAccess.checkBalance();
            } else if (userChoice == 2) {
                refAccess.depositAmount();
            } else if (userChoice == 3) {
                refAccess.withdrawAmount();
            } else {
                System.out.println("Choice not available!");
            }

            System.out.println("Wish to continue? (y/n)");
            String option = refScanner.next();

            if (option.equals("n")){
                continueTransaction = false;
            }
        }
    }

    @Override
    public void resetPassword() {

        String newPassword = null;
        boolean passwordValidated = false;
        boolean passwordEntered = false;

        if(checkSecurityKey()) {

            while (!passwordValidated) {
                try {
                    if (!passwordEntered) {
                        System.out.println("Enter Password: ");
                        newPassword = refScanner.next();
                        passwordEntered = true;
                    } else {
                        System.out.println("Retype Password: ");
                        String confirmPassword = refScanner.next();

                        if (!confirmPassword.equals(newPassword)) {
                            throw new Exception("Password doesn't match!!");
                        }
                        passwordValidated = true;
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }

            System.out.println("What is favourite colour ?");
            String newSecurityKey = refScanner.next();
            System.out.println(newSecurityKey + " is your security key, in case if you forget your password.");

            refAccess.resetPassword(newPassword, newSecurityKey);
        } else {
            System.out.println("Sorry! Wrong security key.");
        }
    }

    public boolean checkSecurityKey(){

        System.out.println("Enter User Email: ");
        String userInputEmail = refScanner.next();

        System.out.println("Enter Security Key: ");
        String userInputKey = refScanner.next();

        return refAccess.checkSecurityKey(userInputEmail, userInputKey);
    }
}
