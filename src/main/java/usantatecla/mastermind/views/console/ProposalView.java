package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	private ProposeController proposeController;
	
	private SecretCombinationView secretCombinationView;

	ProposalView(ProposeController proposeController) {
		this.proposeController = proposeController;
		this.secretCombinationView = new SecretCombinationView();
	}

	boolean interact() {
		ProposedCombination proposedCombination = new ProposedCombination();
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
		proposedCombinationView.read();
		this.proposeController.addProposedCombination(proposedCombination);
		this.console.writeln();
		MessageView.ATTEMPTS.writeln(this.proposeController.getAttempts());
		this.secretCombinationView.writeln();
		for (int i = 0; i < this.proposeController.getAttempts(); i++) {
			new ProposedCombinationView(this.proposeController.getProposedCombination(i)).write();
			new ResultView(this.proposeController.getResult(i)).writeln();
		}
		if (this.proposeController.isWinner()) {
			MessageView.WINNER.writeln();
			return true;
		} else if (this.proposeController.isLooser()) {
			MessageView.LOOSER.writeln();
			return true;
		}
		return false;
	}

}
