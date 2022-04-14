package io.labforward.javadojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.labforward.javadojo.UserDto.UserDtoBuilder;

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
 * Visualize who is in the round as navigator and
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
		Assertions.assertThatThrownBy(() -> registration.process()).hasMessage("Name is missing");
	}

	@Test
	void shouldValidatePresenceOfUserEmail() {
		// given
		UserDto nullEmail = createDefaultUserDynamicSample().email(null).build();
		// when
		UserRegistration registration = new UserRegistration(nullEmail);

		// then
		Assertions.assertThatThrownBy(() -> registration.process()).hasMessage("Email is missing");
	}

	@Test
	void shouldValidatePresenceOfUserPassword() {
		// given
		UserDto nullPassword = createDefaultUserDynamicSample().password(null).build();
		// when
		UserRegistration registration = new UserRegistration(nullPassword);
		// then
		Assertions.assertThatThrownBy(() -> registration.process()).hasMessage("Password is missing");
	}

	@Test
	void shouldValidateLengthOfUserPassword() {
		// given
		UserDto shortPassword = createDefaultUserDynamicSample().password("short").build();
		// when
		UserRegistration registration = new UserRegistration(shortPassword);
		// then
		Assertions.assertThatThrownBy(() -> registration.process()).hasMessage("Password is too short");
	}

}
