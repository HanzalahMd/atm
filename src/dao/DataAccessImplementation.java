package dao;

import pojo.*;

public class DataAccessImplementation implements DataAccessInterface{

    User refUser;

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
}


