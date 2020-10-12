package sanguino.mastermind.views;

import sanguino.mastermind.models.Combination;
import sanguino.mastermind.models.Game;
import sanguino.utils.CombinationStringDialog;

class PlayView {

    private Game game;

    PlayView(Game game) {
        this.game = game;
    }

    void writeGameResult() {
        if (this.game.isWinner()) {
            Message.PLAYER_WIN.writeln();
        } else {
            Message.PLAYER_LOOSE.writeln();
        }
    }

    void interact() {
        new GameView(this.game).write();
        do {
            this.game.nextTurn(new CombinationStringDialog().read(Message.ENTER_COMBINATION.toString(), Combination.NUMBER_COLORS));
            new GameView(this.game).write();
        } while (!this.game.isFinished());
        writeGameResult();
    }
}