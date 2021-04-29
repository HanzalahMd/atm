package service;

import dao.*;
import pojo.User;

import java.util.Scanner;

public class RegisterImplementation implements RegisterInterface {

    Scanner refScanner = new Scanner(System.in);
    DataAccessInterface refAccess;

    @Override
    public void UserRegistration() {

        String userInputEmail = null;
        String userInputPassword = null;
        String userInputKey;
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
                userInputKey = refScanner.next();
                System.out.println(userInputKey + " is your security key, in case if you forget your password.");

                refAccess = new DataAccessImplementation();
                refAccess.createNewUser(userInputEmail, userInputPassword, userInputKey);
                registrationComplete = true;

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } // End of while (!registrationComplete) loop
    } // End of userRegistration() method
}
