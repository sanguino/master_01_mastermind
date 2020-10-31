package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public void next() {
        this.session.nextState();
    }

    public StateValue getValueState() {
        return this.session.getValueState();
    }

}
