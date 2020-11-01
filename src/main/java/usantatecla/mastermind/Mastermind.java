package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.UseCaseController;
import usantatecla.mastermind.views.View;

public class Mastermind {

    protected View view;
    private Logic logic;

    protected Mastermind() {
        this.logic = new Logic();
        this.view = new View();
    }

    protected void play() {
        UseCaseController controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

}
