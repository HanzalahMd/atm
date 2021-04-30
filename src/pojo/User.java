package pojo;

public class User {

    // generate necessary variables and make it private
    private String userEmail;
    private String userPassword;
    private String securityKey;
    private double bankBalance;

    // use setter method to create one new user and pass all the values input using parameters
    public void insertData(String userEmail, String userPassword, String securityKey){
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.securityKey = securityKey;
    }

    // Getter methods - to get the user values
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

    // Setter methods - to modify user values
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
