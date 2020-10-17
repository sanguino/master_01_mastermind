package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	private SecretCombinationView secretCombinationView;

	ProposalView() {
		this.secretCombinationView = new SecretCombinationView();
	}

	void interact(ProposeController proposeController) {
		ProposedCombination proposedCombination = new ProposedCombination();
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
		proposedCombinationView.read();
		proposeController.addProposedCombination(proposedCombination);
		this.console.writeln();
		MessageView.ATTEMPTS.writeln(proposeController.getAttempts());
		this.secretCombinationView.writeln();
		for (int i = 0; i < proposeController.getAttempts(); i++) {
			new ProposedCombinationView(proposeController.getProposedCombination(i)).write();
			new ResultView(proposeController.getResult(i)).writeln();
		}
		if (proposeController.isWinner()) {
			MessageView.WINNER.writeln();
		} else if (proposeController.isLooser()) {
			MessageView.LOOSER.writeln();
		}
	}

}
