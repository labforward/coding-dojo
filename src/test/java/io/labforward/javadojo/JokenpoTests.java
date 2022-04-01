package io.labforward.javadojo;

import org.assertj.core.api.Assertions;
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
	void rockShouldBeatsSizor() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.ROCK, Jokenpo.SIZOR)).isEqualTo("Player 1 wins!");
	}

	@Test
	void rockShouldLoseToPaper() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.ROCK, Jokenpo.PAPER)).isEqualTo("Player 2 wins!");
	}

	@Test
	void paperShouldBeatRock() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.PAPER, Jokenpo.ROCK)).isEqualTo("Player 1 wins!");
	}

	@Test
	void paperShouldLoseToSizor() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.PAPER, Jokenpo.SIZOR)).isEqualTo("Player 2 wins!");
	}

	@Test
	void sizorShouldLoseToRock() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.SIZOR, Jokenpo.ROCK)).isEqualTo("Player 2 wins!");
	}

	@Test
	void sizorShouldBeatPaper() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.SIZOR, Jokenpo.PAPER)).isEqualTo("Player 1 wins!");
	}

	@Test
	void sizorShouldDrawWithSizor() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.SIZOR, Jokenpo.SIZOR)).isEqualTo("Draw! Play again.");
	}

	@Test
	void paperShouldDrawWithPaper() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.PAPER, Jokenpo.PAPER)).isEqualTo("Draw! Play again.");
	}

	@Test
	void rockShouldDrawWithRock() {
		Jokenpo jokenpo = new Jokenpo();

		Assertions.assertThat(jokenpo.evaluate(Jokenpo.ROCK, Jokenpo.ROCK)).isEqualTo("Draw! Play again.");
	}
}
