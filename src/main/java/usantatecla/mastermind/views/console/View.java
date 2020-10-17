package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.*;

public class View extends usantatecla.mastermind.views.View implements ControllerVisitor {

	private StartView startView;
	private ProposalView proposalView;
	private ResumeView resumeView;

	public View() {
		super();
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void interact(UseCaseController controller) {
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}

	@Override
	public void visit(ProposeController proposeController) {
		proposalView.interact(proposeController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		resumeView.interact(resumeController);
	}
}
