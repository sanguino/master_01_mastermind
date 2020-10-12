package sanguino.mastermind.models;

public class Game {
    
    private Board board;
    
    public Game() {
        this.board = new Board();
    }

    public void reset() {
        this.board.reset();
    }

    public void nextTurn(String proposed) {
        this.board.nextTurn(proposed);
    }

    public int getTurn() {
        return this.board.getTurn();
    }

    public String getProposedCombination(int i) {
        return this.board.getProposedCombination(i).toString();
    }

    public long getResultBlacks(int i) {
        return this.board.getResult(i).getBlacks();
    }

    public long getResultWhites(int i) {
        return this.board.getResult(i).getWhites();
    }

    public boolean isFinished() {
        return this.board.isFinished();
    }

    public boolean isWinner() {
        return this.board.getResult(this.board.getTurn()).isWinner();
    }
}