package sanguino.mastermind.models;

class Board {
	static final int NUMBER_TURNS = 10;
	private int turn;
	private ProposedCombination[] proposedCombination;
	private Result[] result;
	private SecretCombination secretCombination;

	Board() {
		proposedCombination = new ProposedCombination[Board.NUMBER_TURNS];
		result = new Result[Board.NUMBER_TURNS];
		this.reset();
	}

	public void reset() {
		for (int i = 0; i < Board.NUMBER_TURNS; i++) {
			proposedCombination[i] = null;
			result[i] = null;
		}
		secretCombination = new SecretCombination();
		turn = -1;
	}

	public void nextTurn(String proposed) {
		turn ++;
		proposedCombination[turn] = new ProposedCombination(proposed);
		result[turn] = secretCombination.check(proposedCombination[turn]);
	}

	public boolean isFinished() {
		return turn == Board.NUMBER_TURNS - 1 || result[turn].isWinner();
	}

	public int getTurn() {
		return this.turn;
	}

	public ProposedCombination getProposedCombination(int i) {
		return this.proposedCombination[i];
	}

	public Result getResult(int i) {
		return this.result[i];
	}

}
