package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.Logic;

public class View extends usantatecla.mastermind.views.View {

	public View(Logic logic) {
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
