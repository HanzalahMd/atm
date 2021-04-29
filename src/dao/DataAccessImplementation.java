package dao;

import pojo.User;

public class DataAccessImplementation implements DataAccessInterface{

    User refUser;

    @Override
    public void createNewUser(String userEmail, String userPassword, String securityKey) {

        refUser = new User();
        refUser.createNewUser(userEmail, userPassword, securityKey);

    }
}


