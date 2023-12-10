package view;

import controller.PrincipalController;

public class App {
    public static void main(String[] args) {
        PrincipalController principal = new PrincipalController();
        principal.setVisible(true);
    }
}
