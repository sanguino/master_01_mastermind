package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class ResumeController extends AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public void resume() {
        this.session.reset();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
