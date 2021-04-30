package pojo;

import java.util.ArrayList;

public class User {

    private String userEmail = "as";
    private String userPassword;
    private String securityKey;
    private double bankBalance = 0;

    ArrayList<User> userDB = new ArrayList<>();

    public void insertData(String userEmail, String userPassword, String securityKey){
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.securityKey = securityKey;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }
}
