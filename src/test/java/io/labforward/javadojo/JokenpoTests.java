package io.labforward.javadojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * ============ Jokenpo game ================
 * Rules:
 * -> All players play at the same time
 * -> It accepts two players;
 * -> Each player plays one form -ROCK, PAPER, SIZOR;
 * -> ROCK beats SIZOR and loses to PAPER;
 * -> PAPER beats ROCK and loses to SIZOR;
 * -> SIZOR beats PAPER and loses to ROCK;
 * -> Equal forms result in drawn;
 * 
 * The game can print:
 * Player 1 wins!
 * Player 2 wins!
 * Draw! Play again.
 */
class JokenpoTests {
	@Test
	void shouldWelcomeUser() {
		String welcomeMessage = Jokenpo.welcome();

		assertThat(welcomeMessage).isEqualTo("Welcome to Dojo");
	}

	@Test
	void shouldPlayer1WinsWhenRockBeatScissors() {
		assertThat(Jokenpo.draw(Hands.ROCK, Hands.SCISSOR)).isEqualTo(Result.PLAYER1.toString());
	}

	@Test
	void shouldPlayer1WinsWhenScissorBeatPaper() {
		assertThat(Jokenpo.draw(Hands.SCISSOR, Hands.PAPER)).isEqualTo(Result.PLAYER1.toString());
	}

	@Test
	void shouldPlayer1WinsWhenPaperBeatRock() {
		assertThat(Jokenpo.draw(Hands.PAPER, Hands.ROCK)).isEqualTo(Result.PLAYER1.toString());
	}

	@Test
	void shouldPlayer2WinsWhenRockBeatScissors() {
		assertThat(Jokenpo.draw(Hands.SCISSOR, Hands.ROCK)).isEqualTo(Result.PLAYER2.toString());
	}

	@Test
	void shouldPlayer2WinsWhenScissorBeatPaper() {
		assertThat(Jokenpo.draw(Hands.PAPER, Hands.SCISSOR)).isEqualTo(Result.PLAYER2.toString());

	}

	@Test
	void shouldPlayer2WinsWhenPaperBeatRock() {
		assertThat(Jokenpo.draw(Hands.ROCK, Hands.PAPER)).isEqualTo(Result.PLAYER2.toString());
	}

	@Test
	void shouldDrawWithRocks() {
		assertThat(Jokenpo.draw(Hands.ROCK, Hands.ROCK)).isEqualTo(Result.DRAW.toString());
	}

	@Test
	void shouldDrawWithPapers() {
		assertThat(Jokenpo.draw(Hands.PAPER, Hands.PAPER)).isEqualTo(Result.DRAW.toString());
	}

	@Test
	void shouldDrawWithScissors() {
		assertThat(Jokenpo.draw(Hands.SCISSOR, Hands.SCISSOR)).isEqualTo(Result.DRAW.toString());
	}

}
