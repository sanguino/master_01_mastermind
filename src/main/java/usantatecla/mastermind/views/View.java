package usantatecla.mastermind.views;

public abstract class View {

	public View() {}

	public void interact() {
		boolean newGame;
		do {
			this.start();
			boolean finished;
			do {
				finished = this.propose();
			} while (!finished);
			newGame = this.isNewGame();
		} while (newGame);
	}

	protected abstract void start();
	protected abstract boolean propose();
	protected abstract boolean isNewGame();

}
