package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.ProposeController;
import usantatecla.mastermind.controllers.ResumeController;

public class View extends usantatecla.mastermind.views.View {

	public View(ProposeController proposeController, ResumeController resumeController) {
		super();
	}

	@Override
	protected void start() {

	}

	@Override
	protected boolean propose() { return false; }

	@Override
	protected boolean isNewGame() { return false; }
}
