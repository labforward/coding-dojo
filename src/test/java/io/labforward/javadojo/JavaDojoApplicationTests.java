package io.labforward.javadojo;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JavaDojoApplicationTests {

	@Test
	void shouldWelcomeUser() {
		String welcomeMessage = JavaDojoApplication.welcome();

		assertThat(welcomeMessage).isEqualTo("Welcome goff");
	}
}
