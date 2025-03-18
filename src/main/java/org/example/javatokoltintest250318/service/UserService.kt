package org.example.javatokoltintest250318.service;

import java.util.Optional;

import org.example.javatokoltintest250318.entity.User;
import org.example.javatokoltintest250318.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// C
	public User createUser(String username, String email) {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);

		return userRepository.save(user);
	}

	// R
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}

	// U
	public User updateUser(Long id, String updateUsername) {
		User user = userRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("User not found"));

		user.setUsername(updateUsername);

		return userRepository.save(user);
	}

	// D
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
