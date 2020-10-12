package sanguino.mastermind;

import sanguino.mastermind.models.Game;
import sanguino.mastermind.views.View;

class MasterMind {

	private Game game;
	private View view;

	MasterMind() {
		this.game = new Game();
		this.view = new View(this.game);
	}

	private void play() {
		this.view.interact();
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}

}
