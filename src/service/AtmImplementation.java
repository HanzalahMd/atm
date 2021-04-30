package service;

import dao.*;
import pojo.*;

import java.util.Scanner;

public class AtmImplementation implements AtmInterface {

    Scanner refScanner = new Scanner(System.in);
    DataAccessInterface refAccess; // Declare globally so other methods can access the same User object

    @Override
    public void userRegistration() { // start of userRegistration method

        String userInputEmail = null;
        String userInputPassword = null;
        boolean emailValidated = false;
        boolean passwordEntered = false;
        boolean passwordValidated = false;
        boolean registrationComplete = false;

        // creating existing user just for the sake of this problem requirement.
        User existingUser = new User();
        existingUser.insertData("xyz@gmail.com", "xyz", "xyz");

        while (!registrationComplete){ // will continue run this loop until registration is complete
            try {
                while(!emailValidated) { // will continue run this until email has been validated
                    System.out.println("Enter email address: ");
                    userInputEmail = refScanner.next();

                    if (userInputEmail.equals(existingUser.getUserEmail())) { // validate with the existing user
                        throw new Exception("email already exists!!" + "\n");
                    }
                    emailValidated = true; // end the loop if the email does not clash with the existing user
                } // End of while (!emailValidated) loop

                while (!passwordValidated) { // will continue run until password has been validated
                    if(!passwordEntered) {
                        System.out.println("Enter Password: ");
                        userInputPassword = refScanner.next();
                        passwordEntered = true;
                    } else {
                        System.out.println("Retype Password: ");
                        String confirmPassword = refScanner.next();

                        if (!confirmPassword.equals(userInputPassword)) { // check the second input with the first
                            throw new Exception("Password doesn't match!!");
                        }
                        passwordValidated = true; // end the loop after confirmPassword matches userInputPassword
                    }
                } // End of while (!passwordValidated) loop

                System.out.println("What is favourite colour ?");
                String userInputKey = refScanner.next();
                System.out.println(userInputKey + " is your security key, in case if you forget your password.");

                refAccess = new DataAccessImplementation(); // initialize the reference object to access the methods
                refAccess.createNewUser(userInputEmail, userInputPassword, userInputKey); // pass all the user inputs
                registrationComplete = true; // stop this while loop

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } // End of while (!registrationComplete) loop
    } // End of userRegistration() method


    @Override
    public void userLogin() { // start of userLogin method

        boolean isAuthenticated;

        System.out.println("Enter User Email: ");
        String userInputEmail = refScanner.next();

        System.out.println("Enter Password: ");
        String userInputPassword = refScanner.next();

        // check the user inputs with the database and return true if both match
        isAuthenticated = refAccess.authenticateUser(userInputEmail, userInputPassword);

        if(isAuthenticated){
            System.out.println("Login Successful!!");
            beginTransaction(); // call this method only after user has been authenticated
        } else {
            System.out.println("Sorry invalid credentials! Please try again. \n");
            userLogin(); // prompt user inputs again if it's not authenticated
        }
    } // end of userLogin method


    public void beginTransaction(){ // start of beginTransaction method that only available after user is authenticated

        boolean continueTransaction = true; // will always be true until user inputs 'n'

        while(continueTransaction) { // will continue run this loop until user inputs 'n'
            System.out.println();
            System.out.println("(1) Check Available Bank Balance " + "\n"
                    + "(2) Deposit Amount" + "\n"
                    + "(3) Withdraw Amount");

            System.out.println("Enter Your Choice: ");
            int userChoice = refScanner.nextInt();

            if (userChoice == 1) {
                refAccess.checkBalance(); // call the checkBalance method in dao
            } else if (userChoice == 2) {
                refAccess.depositAmount(); // call the depositAmount method in dao
            } else if (userChoice == 3) {
                refAccess.withdrawAmount(); // call the withdrawAmount method in dao
            } else {
                System.out.println("Choice not available!");
            }

            System.out.println("Wish to continue? (y/n)");
            String option = refScanner.next();

            if (option.equals("n")){  // stop the loop if user inputs 'n'
                continueTransaction = false;
            }
        } // end of continueTransaction loop
    } // end of beginTransaction loop

    @Override
    public void resetPassword() { // start of resetPassword method

        String newPassword = null;
        boolean passwordValidated = false;
        boolean passwordEntered = false;

        if(checkSecurityKey()) { // check the security key first, if correct then can change password
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
            } // end of passwordValidated loop

            System.out.println("What is favourite colour ?");
            String newSecurityKey = refScanner.next();
            System.out.println(newSecurityKey + " is your security key, in case if you forget your password.");

            refAccess.resetPassword(newPassword, newSecurityKey);
        } else {
            System.out.println("Sorry! Wrong security key.");
        }
    } // end of resetPassword method

    public boolean checkSecurityKey(){ // check the user input security key

        System.out.println("Enter User Email: ");
        String userInputEmail = refScanner.next();

        System.out.println("Enter Security Key: ");
        String userInputKey = refScanner.next();

        return refAccess.checkSecurityKey(userInputEmail, userInputKey); // return true if key is correct
    }
}
