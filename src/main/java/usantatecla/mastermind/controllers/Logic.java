package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Game game;
    private State state;
    private Map<StateValue, UseCaseController> controllers;

    public Logic() {
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

    public UseCaseController getController() {
        return this.controllers.get(this.state.getValueState());
    }
}
