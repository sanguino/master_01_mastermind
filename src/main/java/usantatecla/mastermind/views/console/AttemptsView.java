package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

    public void write(PlayController playController) {
        this.console.writeln();
        MessageView.ATTEMPTS.writeln(playController.getAttempts());
        new SecretCombinationView().writeln();
        for (int i = 0; i < playController.getAttempts(); i++) {
            new ProposeCombinationView(playController.getProposedCombination(i)).write();
            new ResultView(playController.getResult(i)).writeln();
        }
    }

}
