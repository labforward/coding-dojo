package io.labforward.javadojo;

class Jokenpo {

	static String welcome() {
		return "Welcome to Dojo";
	}

	static String draw(Hands player1, Hands player2) {
		if (player1 == Hands.ROCK && player2 == Hands.SCISSOR) {
			return "Player 1 wins!";
		}
		if (player1 == Hands.SCISSOR && player2 == Hands.PAPER) {
			return "Player 1 wins!";
		}
		if (player1 == Hands.PAPER && player2 == Hands.ROCK) {
			return "Player 1 wins!";
		}
		if (player1.equals(player2)) {
			return "Draw! Play again.";
		}
		return "Player 2 wins!";
	}

}
