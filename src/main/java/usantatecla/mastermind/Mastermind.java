package usantatecla.mastermind;

import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

    protected Game game;

    protected View view;

    private ProposeController proposeController;
    private ResumeController resumeController;

    protected Mastermind() {
        this.game = new Game();
        this.proposeController = new ProposeController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView(this.proposeController, this.resumeController);
    }

    protected abstract View createView(ProposeController proposeController, ResumeController resumeController);

    protected void play() {
        this.view.interact();
    }

}
