package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;

public class ProposeController extends Controller {

    private SessionImplementation sessionImplementation;

    public ProposeController(Session session) {
        super(session);
        this.sessionImplementation = ((SessionImplementation) this.session);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.sessionImplementation.addProposedCombination(proposedCombination);
        if (this.isWinner() || this.isLooser()) {
            this.next();
        }
    }

    public int getAttempts() {
        return this.sessionImplementation.getAttempts();
    }

    public ProposedCombination getProposedCombination(int i) {
        return this.sessionImplementation.getProposedCombination(i);
    }

    public Result getResult(int i) {
        return this.sessionImplementation.getResult(i);
    }

    public boolean isWinner() {
        return this.sessionImplementation.isWinner();
    }

    public boolean isLooser() {
        return this.sessionImplementation.isLooser();
    }

}
