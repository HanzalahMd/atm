package application;

import controller.AtmController;

public class Main {
    public static void main(String[] args) {
        AtmController refController = new AtmController();
        refController.callRegisterService();
    }
}
