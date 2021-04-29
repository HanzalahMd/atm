package controller;

import service.*;

public class AtmController {

    public void callRegisterService(){
        RegisterInterface refInterface = new RegisterImplementation();
        refInterface.UserRegistration();
    }
}
