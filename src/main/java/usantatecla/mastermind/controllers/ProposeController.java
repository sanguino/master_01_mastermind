package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Error;
import usantatecla.mastermind.models.*;
import usantatecla.mastermind.views.MessageView;
import usantatecla.mastermind.views.ProposedCombinationView;
import usantatecla.mastermind.views.SecretCombinationView;

public class ProposeController extends Controller {

    private SecretCombinationView secretCombinationView;

    public ProposeController(Game game, State state) {
        super(game, state);
        this.secretCombinationView = new SecretCombinationView();
    }

    @Override
    public void control() {
        this.getProposeCombination();
        this.showProposedCombinations();
        this.checkWinnerOrLooser();
    }

    private void getProposeCombination() {
        Error error;
        ProposedCombination proposedCombination = new ProposedCombination();
        do {
            error = null;
            String characters = new ProposedCombinationView().read();
            if (characters.length() > Combination.getWidth()) {
                error = Error.WRONG_LENGTH;
            } else {
                for (int i = 0; i < characters.length(); i++) {
                    Color color = Color.getColor(characters.charAt(i));
                    if (color == null) {
                        error = Error.WRONG_CHARACTERS;
                    } else {
                        if (proposedCombination.getColors().contains(color)) {
                            error = Error.DUPLICATED;
                        } else {
                            proposedCombination.getColors().add(color);
                        }
                    }
                }
            }
            if (error != null) {
                MessageView.ERROR.writeln(error.getMessage());
                proposedCombination.getColors().clear();
            }
        } while (error != null);

        this.game.addProposedCombination(proposedCombination);
    }

    private void showProposedCombinations() {
        MessageView.ATTEMPTS.writeln(this.game.getAttempts());
        this.secretCombinationView.writeln(SecretCombination.getWidth());

        for (int i = 0; i < this.game.getAttempts(); i++) {
            String colors = "";
            for (Color color : this.game.getProposedCombination(i).getColors()) {
                colors += color.getCharacter();
            }
            Result result = this.game.getResult(i);
            new ProposedCombinationView().write(colors, result.getBlacks(), result.getWhites());
        }
    }

    private void checkWinnerOrLooser() {
        if (this.game.isWinner()) {
            MessageView.WINNER.writeln();
            this.next();
        } else if (this.game.isLooser()) {
            MessageView.LOOSER.writeln();
            this.next();
        }
    }
}
