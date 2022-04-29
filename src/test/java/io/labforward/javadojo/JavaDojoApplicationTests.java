package io.labforward.javadojo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Rules:
 * No mock framework
 * Focus on the rules, not the integrations
 *
 * ======= User Registration ==========
 * We should register new Users. Users can not be updated;
 * The user shall provide non-empty values for: Name, email, and password;
 * The password must have at least 6 characters;
 * Multiple users can have the same Name, but the email must be unique.
 *
 * ======= User Confirmation ==========
 * The system shall send a confirmation email for the new user’s email;
 * The user shall confirm his account by informing his email and password;
 * Unconfirmed users shall receive the confirmation email everyday at 9am.
 *
 */
class JavaDojoApplicationTests {

	@Test
	void shouldFailNullUsername()  {
		User user = new User();
    user.setUsername(null);
    UserRegistration userRegistration = new UserRegistration();
    Boolean result = userRegistration.register(user);
    assertThat(result).isFalse();
	}

	@Test
	void shouldAcceptNonNullUsername()  {
		User user = new User();
    user.setUsername("user");
    user.setEmail("email@user.com");
    UserRegistration userRegistration = new UserRegistration();
    Boolean result = userRegistration.register(user);
    assertThat(result).isTrue();
	}


	@Test
	void shouldAcceptNonNullEmail()  {
		User user = new User();
		user.setUsername("Name");
        user.setEmail("user@user.com");
        UserRegistration userRegistration = new UserRegistration();
        Boolean result = userRegistration.register(user);
        assertThat(result).isTrue();
	}

	@Test
	void shouldFailNullPassword()  {
		User user = new User();
    user.setPassword(null);
    UserRegistration userRegistration = new UserRegistration();
    Boolean result = userRegistration.register(user);
    assertThat(result).isFalse();
	}

	@Test
	void shouldAcceptNonNullPassword()  {
		User user = new User();
		user.setUsername("username");
		user.setEmail("email@email.com");
    user.setPassword("password");
    UserRegistration userRegistration = new UserRegistration();
    Boolean result = userRegistration.register(user);
    assertThat(result).isTrue();
	}
}
