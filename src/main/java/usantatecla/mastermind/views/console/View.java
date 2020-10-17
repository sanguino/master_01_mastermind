package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;

public class View extends usantatecla.mastermind.views.View {

	private StartView startView;
	private ProposalView proposalView;
	private ResumeView resumeView;

	public View(Logic logic) {
		super();
		this.startView = new StartView();
		this.proposalView = new ProposalView(logic);
		this.resumeView = new ResumeView(logic);
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
