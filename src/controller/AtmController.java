package controller;

import service.AtmInterface;
import service.AtmImplementation;

public class AtmController {

    AtmInterface refInterface; // initialize AtmInterface reference

    public void callRegisterService(){
        refInterface = new AtmImplementation();
        refInterface.UserRegistration(); // call userRegistration in AtmImplementation
    }

    public void callLoginService(){
        refInterface.userLogin(); // call userLogin in AtmImplementation
    }

    public void callResetService(){
        System.out.println("Reset...");
    }
}
