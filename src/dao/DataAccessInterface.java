package dao;

public interface DataAccessInterface {
    void createNewUser(String userEmail, String userPassword, String securityKey);
    boolean authenticateUser(String userEmail, String userPassword);
    boolean checkSecurityKey(String userEmail, String securityKey);
    void checkBalance();
    void depositAmount();
    void withdrawAmount();
    void resetPassword(String newPassword, String newSecurityKey);
}
