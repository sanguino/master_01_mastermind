package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class StartController extends AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
