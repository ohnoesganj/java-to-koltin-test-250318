package org.example.javatokoltintest250318.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.example.javatokoltintest250318.entity.User;
import org.example.javatokoltintest250318.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	// C: BDD test style
	@Test
	void testCreateUser() {
		// given
		String username = "seonho";
		String email = "seonho@gmail.com";

		User user = new User(1L, username, email);
		when(userRepository.save(any(User.class)))
			.thenReturn(user);  // Mock 이용

		// when
		User actual = userService.createUser(username, email);

		// then
		assertNotNull(actual);
		assertEquals(username, actual.getUsername());
		assertEquals(email, actual.getEmail());
	}


	// U
	@Test
	void testUpdateUser_NotExisting() {
		// given
		Long id = 1L;
		String updateUsername = "Kim";
		when(userRepository.findById(id))
			.thenReturn(Optional.empty());  // 빈 값 return

		// when, then
		assertThrows(RuntimeException.class,
			() -> userService.updateUser(id, updateUsername));
	}

	@Test
	void testUpdateUser_Existing() {
		// given
		Long id = 1L;
		String updateUsername = "Kim";

		User user = new User(1L, "seonho", "seonho@gmail.com");
		when(userRepository.findById(id))
			.thenReturn(Optional.of(user));
		when(userRepository.save(user)).thenReturn(user);

		// when
		User actual = userService.updateUser(id, updateUsername);

		// then
		assertNotNull(actual);
		assertEquals(updateUsername, actual.getUsername());
	}



	// R
	@Test
	void testGetUser() {

	}


	// D
	@Test
	void testDeleteUser() {

	}
}