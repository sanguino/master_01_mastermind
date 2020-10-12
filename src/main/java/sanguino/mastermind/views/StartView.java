package sanguino.mastermind.views;

import sanguino.mastermind.models.Game;

class StartView {

    private Game game;

    StartView(Game game) {
        this.game = game;
    }

    void interact() {
        this.game.reset();
        Message.TITTLE.writeln();
    }

}