package io.labforward.javadojo;

import io.labforward.javadojo.UserDto.UserDtoBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	/**
	 * 
	 * Dynamic sample example.
	 * We can use it in all tests. It will provide valid default values.
	 * Each test can focus and replace only the field being tested.
	 */
	private UserDtoBuilder createDefaultUserDynamicSample() {
		return UserDto.builder().email("example@user.com").name("John Doe").password("password123");
	}

	@Test
	void shouldAllowUserToRegisterNewAccount() throws Exception {
		// given
		UserDto completeUser = createDefaultUserDynamicSample().build();
		// when
		UserRegistration registration = new UserRegistration(completeUser);
		// then
		User user = new User("John Doe", "example@user.com", "password123");
		assertEquals(user, registration.process());
	}

	@Test
	void shouldValidatePresenceOfUserName() {
		// given
		UserDto nullName = createDefaultUserDynamicSample().name(null).build();
		// when
		UserRegistration registration = new UserRegistration(nullName);
		// then
		assertThatThrownBy(registration::process).hasMessage("Name is missing");
	}

	@Test
	void shouldValidatePresenceOfUserEmail() {
		// given
		UserDto nullEmail = createDefaultUserDynamicSample().email(null).build();
		// when
		UserRegistration registration = new UserRegistration(nullEmail);
		// then
		assertThatThrownBy(registration::process).hasMessage("Email is missing");
	}

	@Test
	void shouldValidatePresenceOfUserPassword() {
		// given
		UserDto nullPassword = createDefaultUserDynamicSample().password(null).build();
		// when
		UserRegistration registration = new UserRegistration(nullPassword);
		// then
		assertThatThrownBy(registration::process).hasMessage("Password is missing");
	}

	@Test
	void shouldValidateLengthOfUserPassword() {
		// given
		UserDto shortPassword = createDefaultUserDynamicSample().password("short").build();
		// when
		UserRegistration registration = new UserRegistration(shortPassword);
		// then
		assertThatThrownBy(registration::process).hasMessage("Password is too short");
	}

}
