package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Mastermind {

    private Game game;
    private State state;
    private Map<StateValue, Controller> controllers;

    protected Mastermind() {
        this.game = new Game();
        this.state = new State();
        createControllers();
    }

    private void createControllers() {
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.PROPOSE, new ProposeController(this.game, this.state));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    protected void play() {
        Controller controller;
        do {
            controller = this.controllers.get(this.state.getValueState());
            if (controller != null) {
                controller.control();
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

}
