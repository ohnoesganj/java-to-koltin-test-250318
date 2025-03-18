package org.example.javatokoltintest250318.controller;

import java.util.Optional;

import org.example.javatokoltintest250318.entity.User;
import org.example.javatokoltintest250318.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// C
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) {
		User user = userService.createUser(request.getUsername(), request.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(user);  // 201
	}

	// R
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		Optional<User> user = userService.getUser(id);

		return user.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());  // 404
	}

	// U
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(
		@PathVariable Long id,
		@RequestParam String username
	) {
		User user = userService.updateUser(id, username);

		return ResponseEntity.ok(user);
	}

	// D
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);

		return ResponseEntity.noContent().build();
	}
}
