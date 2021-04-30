package controller;

import service.AtmInterface;
import service.AtmImplementation;

public class AtmController {

    AtmInterface refInterface; // initialize AtmInterface reference, all methods will access the same User object

    public void callRegisterService(){
        refInterface = new AtmImplementation();
        refInterface.userRegistration(); // call userRegistration in AtmImplementation
    }

    public void callLoginService(){
        refInterface.userLogin(); // call userLogin in AtmImplementation
    }

    public void callResetService() {
        refInterface.resetPassword(); // call resetPassword in AtmImplementation
    }
}
