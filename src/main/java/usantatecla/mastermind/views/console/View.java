package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.controllers.ResumeController;

public class View extends usantatecla.mastermind.views.View {

	private StartView startView;
	private ProposalView proposalView;
	private ResumeView resumeView;

	public View(ProposeController proposeController, ResumeController resumeController) {
		super();
		this.startView = new StartView();
		this.proposalView = new ProposalView(proposeController);
		this.resumeView = new ResumeView(resumeController);
	}

	@Override
	protected void start() {
		this.startView.interact();
	}

	@Override
	protected boolean propose() {
		return this.proposalView.interact();
	}

	@Override
	protected boolean isNewGame() {
		return this.resumeView.interact();
	}
}
