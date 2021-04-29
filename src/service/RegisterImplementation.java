package service;

import dao.*;

import java.util.Scanner;

public class RegisterImplementation implements RegisterInterface {

    Scanner refScanner = new Scanner(System.in);
    DataAccessInterface refAccess;

    @Override
    public void UserRegistration() {

        System.out.println("Enter email address: ");
        String userInputEmail = refScanner.next();

        System.out.println("Enter Password: ");
        String userInputPassword = refScanner.next();

        System.out.println("What is favourite colour ?");
        String userInputKey = refScanner.next();

        refAccess = new DataAccessImplementation();
        refAccess.createNewUser(userInputEmail, userInputPassword, userInputKey);
    }
}
