package controller;

import service.*;

public class AtmController {

    public void callRegisterService(){
        RegisterInterface refInterface = new RegisterImplementation();
        refInterface.UserRegistration();
    }

    public void callLoginService(){
        System.out.println("Login...");
    }

    public void callResetService(){
        System.out.println("Reset...");
    }
}
