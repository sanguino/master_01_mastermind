package sanguino.mastermind.views;

import sanguino.mastermind.models.Game;

class GameView {

    private Game game;

    GameView(Game game) {
        this.game = game;
    }

    void write() {
        Message.SEPARATOR.writeln();
        Message.ATTEMPTS.writeln(this.game.getTurn() + 1);
        Message.SECRET_CODE.writeln();
        for (int i = 0; i < this.game.getTurn() + 1; i++) {
            Message.RESULT.writeln(this.game.getProposedCombination(i), this.game.getResultBlacks(i), this.game.getResultWhites(i));
        }
    }

}