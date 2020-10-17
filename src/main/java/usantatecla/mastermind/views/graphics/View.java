package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Game;

public class View extends usantatecla.mastermind.views.View {

	public View(Game game) {
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
