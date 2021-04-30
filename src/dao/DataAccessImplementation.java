package dao;

import pojo.*;

import java.util.Scanner;

public class DataAccessImplementation implements DataAccessInterface{

    User refUser; // initialize the reference for User object globally so the other methods can access the same user.
    Scanner refScanner = new Scanner(System.in);

    @Override
    public void createNewUser(String userEmail, String userPassword, String securityKey) {
        refUser = new User();
        refUser.insertData(userEmail, userPassword, securityKey);
        System.out.println("Registration Successful!!");
    }

    @Override
    public boolean authenticateUser(String userEmail, String userPassword) {
        return userEmail.equals(refUser.getUserEmail()) && userPassword.equals(refUser.getUserPassword());
    } // this method will validate user inputs and the User email and password

    @Override
    public boolean checkSecurityKey(String userEmail, String securityKey) {
        return userEmail.equals(refUser.getUserEmail()) && securityKey.equals(refUser.getSecurityKey());
    } // this method will validate user inputs with User email and security key

    @Override
    public void checkBalance(){
        System.out.println("Your bank balance is $" + refUser.getBankBalance());
    }

    @Override
    public void depositAmount(){
        System.out.println("Enter Amount to deposit:");
        double amount = refScanner.nextDouble();

        if(amount < 0){ // reject depositing negative amount
            System.out.println("Amount can't be negative!!");
        } else { // accepts if its positive amount
            refUser.setBankBalance(refUser.getBankBalance() + amount);
            System.out.println("$" + amount + " deposited successfully!");
            System.out.println("Your new balance is $" + refUser.getBankBalance());
        }
    }

    @Override
    public void withdrawAmount(){
        System.out.println("Enter Amount to withdraw:");
        double amount = refScanner.nextDouble();

        if(amount > refUser.getBankBalance()){ // reject withdrawing amount higher than bank balance
            System.out.println("Sorry!! insufficient balance.");
        } else { // accepts if its same or lower than bank balance
            refUser.setBankBalance(refUser.getBankBalance() - amount);
            System.out.println("Transaction successful!");
            System.out.println("Your new balance is $" + refUser.getBankBalance());
        }
    }

    @Override
    public void resetPassword(String newPassword, String newSecurityKey) {
        refUser.setUserPassword(newPassword);
        refUser.setSecurityKey(newSecurityKey);
        System.out.println("Your password has been reset successfully.");
    }
}


