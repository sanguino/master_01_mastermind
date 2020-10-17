package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

    protected View view;
    private Logic logic;

    protected Mastermind() {
        this.logic = new Logic();
        this.view = this.createView(this.logic);
    }

    protected abstract View createView(Logic logic);

    protected void play() {
        this.view.interact();
    }

}
