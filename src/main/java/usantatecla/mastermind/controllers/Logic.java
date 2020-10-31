package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    protected Session session;
    protected Map<StateValue, AcceptorController> controllers;

    public Logic() {
        this.controllers = new HashMap<>();
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
