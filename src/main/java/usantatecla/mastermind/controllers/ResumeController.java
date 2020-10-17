package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;

public class ResumeController {

    private Game game;

    public ResumeController(Game game) {
        this.game = game;
    }

    public void resume() {
        this.game.clear();
    }
}
