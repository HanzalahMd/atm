package pojo;

public class User {

    private String userEmail;
    private String userPassword;
    private String securityKey;
    private double bankBalance;

    public void insertData(String userEmail, String userPassword, String securityKey){
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.securityKey = securityKey;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public String getSecurityKey() {
        return securityKey;
    }
    public double getBankBalance() {
        return bankBalance;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }
    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }
}
