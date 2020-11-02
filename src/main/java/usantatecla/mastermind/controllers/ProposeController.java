package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Error;
import usantatecla.mastermind.models.*;
import usantatecla.mastermind.views.*;

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
                    Color color = Color.values()[ColorView.getOrdinal(characters.charAt(i))];
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
                new ErrorView(error).writeln();
                proposedCombination.getColors().clear();
            }
        } while (error != null);

        this.game.addProposedCombination(proposedCombination);
    }

    private void showProposedCombinations() {
        new AttempsView().writeln(this.game.getAttempts());
        this.secretCombinationView.writeln(SecretCombination.getWidth());

        for (int i = 0; i < this.game.getAttempts(); i++) {
            String colors = "";
            for (Color color : this.game.getProposedCombination(i).getColors()) {
                colors += ColorView.getCharacter(color.ordinal());
            }
            Result result = this.game.getResult(i);
            new ProposedCombinationView().write(colors, result.getBlacks(), result.getWhites());
        }
    }

    private void checkWinnerOrLooser() {
        if (this.game.isWinner()) {
            new EndView().writeWinner();
            this.next();
        } else if (this.game.isLooser()) {
            new EndView().writeLooser();
            this.next();
        }
    }
}
