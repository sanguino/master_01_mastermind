package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.SecretCombination;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.views.MessageView;
import usantatecla.mastermind.views.SecretCombinationView;


public class StartController extends Controller {
    public StartController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void control() {
        MessageView.TITLE.writeln();
        new SecretCombinationView().writeln(SecretCombination.getWidth());
        this.next();
    }

}
