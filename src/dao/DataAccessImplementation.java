package dao;

import pojo.*;

import java.util.Scanner;

public class DataAccessImplementation implements DataAccessInterface{

    User refUser;
    Scanner refScanner = new Scanner(System.in);
    double bankBalance = refUser.getBankBalance();

    @Override
    public void createNewUser(String userEmail, String userPassword, String securityKey) {
        refUser = new User();
        refUser.insertData(userEmail, userPassword, securityKey);
        System.out.println("Registration Successful!!");
    }

    @Override
    public boolean authenticateUser(String userEmail, String userPassword) {
        return userEmail.equals(refUser.getUserEmail()) && userPassword.equals(refUser.getUserPassword());
    }

    @Override
    public void checkBalance(){
        System.out.println(refUser.getBankBalance());
    }

    @Override
    public void depositAmount(){
        System.out.println("Enter Amount to deposit:");
        double amount = refScanner.nextDouble();

        if(amount < 0){
            System.out.println("Amount can't be negative!!");
        } else {
            refUser.setBankBalance(bankBalance + amount);
            System.out.println("$" + amount + " deposited successfully!");
            System.out.println("Your new balance is $" + bankBalance);
        }
    }

    @Override
    public void withdrawAmount(){
        System.out.println("Enter Amount to withdraw:");
        double amount = refScanner.nextDouble();

        if(amount > bankBalance){
            System.out.println("Sorry!! insufficient balance.");
        } else {
            refUser.setBankBalance(bankBalance - amount);
            System.out.println("Transaction successful!");
            System.out.println("Your new balance is $" + bankBalance);
        }
    }
}


