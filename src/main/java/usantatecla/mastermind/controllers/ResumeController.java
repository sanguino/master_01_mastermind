package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class ResumeController extends AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public abstract void resume();

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
