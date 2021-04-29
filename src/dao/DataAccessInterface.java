package dao;

public interface DataAccessInterface {
    void createNewUser(String userEmail, String userPassword, String securityKey);
}
