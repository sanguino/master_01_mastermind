package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;

public abstract class UseCaseController {
    protected Game game;
    protected State state;

    UseCaseController(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public void next() {
        this.state.next();
    }

    public abstract void accept(ControllerVisitor controllerVisitor);
}
