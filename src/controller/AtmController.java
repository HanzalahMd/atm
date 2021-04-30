package controller;

import service.*;

public class AtmController {

    AtmInterface refInterface;

    public void callRegisterService(){
        refInterface = new AtmImplementation();
        refInterface.UserRegistration();
    }

    public void callLoginService(){
        refInterface.userLogin();
    }

    public void callResetService(){
        System.out.println("Reset...");
    }
}
