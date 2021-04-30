package dao;

public interface DataAccessInterface {
    void createNewUser(String userEmail, String userPassword, String securityKey);
    boolean authenticateUser(String userEmail, String userPassword);
    void checkBalance();
    void depositAmount();
    void withdrawAmount();
}
