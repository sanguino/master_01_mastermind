package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;

public class ProposeController extends Controller {

    public ProposeController(Session session) {
        super(session);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.session.addProposedCombination(proposedCombination);
        if (this.isWinner() || this.isLooser()) {
            this.next();
        }
    }

    public int getAttempts() {
        return this.session.getAttempts();
    }

    public ProposedCombination getProposedCombination(int i) {
        return this.session.getProposedCombination(i);
    }

    public Result getResult(int i) {
        return this.session.getResult(i);
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    public boolean isLooser() {
        return this.session.isLooser();
    }

}
