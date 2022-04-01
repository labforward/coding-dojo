package io.labforward.javadojo;

class Jokenpo {
	public static final String ROCK = "Rock";
	public static final String PAPER = "Paper";
	public static final String SIZOR = "Sizor";

	private static final String PLAYER1_WINS = "Player 1 wins!";
	private static final String PLAYER2_WINS = "Player 2 wins!";
	private static final String DRAW = "Draw! Play again.";

	public Jokenpo() {

	}

	public void addPlayer() {

	}

	String evaluate(String playerInput1, String playerInput2) {
		if (playerInput1.equals(playerInput2))
			return DRAW;
		if (player2wins(playerInput1, playerInput2)) {
			return PLAYER2_WINS;
		} else
			return PLAYER1_WINS;
	}

	private boolean player2wins(String playerInput1, String playerInput2) {
		if (playerInput1.equals(ROCK) && playerInput2.equals(PAPER))
			return true;
		else if (playerInput1.equals(PAPER) && playerInput2.equals(SIZOR))
			return true;
		else if (playerInput1.equals(SIZOR) && playerInput2.equals(ROCK))
			return true;
		return false;
	}

}
