package io.labforward.javadojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * ======= User Registration ==========
 * We should register new Users. Users can not be updated;
 * The user shall provide non-empty values for: Name, email, and password;
 * The password must have at least 6 characters;
 * Multiple users can have the same Name, but the email must be unique.
 * 
 * ======= User Confirmation ==========
 * The system shall send a confirmation email for the new user's email;
 * The user shall confirm his account by informing his email and password;
 * Unconfirmed users shall receive the confirmation email everyday at 9am.
 */
class JavaDojoApplicationTests {

	@Test
	void shouldWelcomeUser() {
		String welcomeMessage = JavaDojoApplication.welcome();

		assertThat(welcomeMessage).isEqualTo("Welcome goff");
	}
}
