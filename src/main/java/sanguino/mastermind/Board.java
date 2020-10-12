package sanguino.mastermind;

import sanguino.utils.CombinationStringDialog;

class Board {
	static final int NUMBER_TURNS = 10;
	private int turn;
	private ProposedCombination[] proposedCombination;
	private Result[] result;
	private SecretCombination secretCombination;

	Board() {
		secretCombination = new SecretCombination();
		proposedCombination = new ProposedCombination[Board.NUMBER_TURNS];
		result = new Result[Board.NUMBER_TURNS];
		turn = -1;

		Message.TITTLE.writeln();
	}

	void write() {
		Message.SEPARATOR.writeln();
		Message.ATTEMPTS.writeln(turn + 1);
		Message.SECRET_CODE.writeln();
		for (int i = 0; i < turn +1; i++) {
			Message.RESULT.writeln(proposedCombination[i].toString(), result[i].toString());
		}

	}

	public void nextTurn() {
		turn ++;
		String proposed = new CombinationStringDialog().read(Message.ENTER_COMBINATION.toString(), Combination.NUMBER_COLORS);
		proposedCombination[turn] = new ProposedCombination(proposed);
		result[turn] = secretCombination.check(proposedCombination[turn]);
	}

	public boolean isFinished() {
		return turn == Board.NUMBER_TURNS - 1 || result[turn].isWinner();
	}

	public void writeGameResult() {
		if (result[turn].isWinner()) {
			Message.PLAYER_WIN.writeln();
		} else {
			Message.PLAYER_LOOSE.writeln();
		}
	}
}
