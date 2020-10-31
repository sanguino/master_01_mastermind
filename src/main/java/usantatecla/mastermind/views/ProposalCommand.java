package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.ProposedCombination;

public class ProposalCommand extends PlayCommand {

    protected ProposalCommand(PlayController playController) {
        super(MessageView.PROPOSE_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        ProposedCombination proposedCombination = new ProposedCombination();
        ProposeCombinationView proposeCombinationView = new ProposeCombinationView(proposedCombination);
        proposeCombinationView.read();
        this.playController.addProposedCombination(proposedCombination);
        new AttemptsView().write(playController);
        if (this.playController.isWinner()) {
            MessageView.WINNER.writeln();
        } else if (this.playController.isLooser()) {
            MessageView.LOOSER.writeln();
        }
    }

    @Override
    protected boolean isActive() {
        return true;
    }

}
