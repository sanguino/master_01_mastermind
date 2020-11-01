package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.YesNoDialog;

public class ResumeController extends Controller {

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void control() {
        MessageView.RESUME.write();

        if (new YesNoDialog().read()) {
            this.resume();
        } else {
            this.next();
        }
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
    }

}
