package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;

public class Logic {

    private Game game;
    private ProposeController proposeController;
    private ResumeController resumeController;

    public Logic () {
        this.game = new Game();
        this.proposeController = new ProposeController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposeController.addProposedCombination(proposedCombination);
    }

    public int getAttempts() {
        return this.proposeController.getAttempts();
    }

    public ProposedCombination getProposedCombination(int i) {
        return this.proposeController.getProposedCombination(i);
    }

    public Result getResult(int i) {
        return this.proposeController.getResult(i);
    }

    public boolean isWinner() {
        return this.proposeController.isWinner();
    }

    public boolean isLooser() {
        return this.proposeController.isLooser();
    }

    public void resume() {
        this.resumeController.resume();
    }
}
