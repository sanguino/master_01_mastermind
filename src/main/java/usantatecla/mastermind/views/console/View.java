package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.*;

public class View extends usantatecla.mastermind.views.View implements ControllerVisitor {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public View() {
        super();
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void interact(AcceptorController controller) {
        controller.accept(this);
    }

    public void visit(StartController startController) {
        startView.interact(startController);
    }

    public void visit(PlayController playController) {
        playView.interact(playController);
    }

    public void visit(ResumeController resumeController) {
        resumeView.interact(resumeController);
    }

}
