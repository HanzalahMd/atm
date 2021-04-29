package service;

import dao.*;
import pojo.User;

import java.util.Scanner;

public class RegisterImplementation implements RegisterInterface {

    Scanner refScanner = new Scanner(System.in);
    DataAccessInterface refAccess;
    boolean validated;

    @Override
    public void UserRegistration() {

        User existingUser = new User();
        existingUser.insertData("xyz@gmail.com", "xyz", "xyz");

        while(!validated) {
            try {
                System.out.println("Enter email address: ");
                String userInputEmail = refScanner.next();

                if (userInputEmail.equals(existingUser.getUserEmail())) {
                    throw new Exception("email already exists!!" + "\n");
                }

                System.out.println("Enter Password: ");
                String userInputPassword = refScanner.next();

                System.out.println("What is favourite colour ?");
                String userInputKey = refScanner.next();

                refAccess = new DataAccessImplementation();
                refAccess.createNewUser(userInputEmail, userInputPassword, userInputKey);
                validated = true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
