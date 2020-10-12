package sanguino.mastermind;

import sanguino.utils.YesNoDialog;

class MasterMind {

    private Board board;

    private void play() {
        do {
            this.playGame();
        } while (this.isResumedGame());
    }

    private void playGame() {
        this.board = new Board();
        this.board.write();
        do {
            this.board.nextTurn();
            this.board.write();
        } while (!this.board.isFinished());
        this.board.writeGameResult();
    }

    private boolean isResumedGame() {
        return new YesNoDialog().read(Message.RESUME.toString());
    }

    public static void main(String[] args) {
        new MasterMind().play();
    }

}
