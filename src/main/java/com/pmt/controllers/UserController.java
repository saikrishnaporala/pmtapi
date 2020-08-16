package com.pmt.controllers;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.models.User;
import com.pmt.services.UserService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserController {

	static final Logger logger = LogManager.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;

	// displaying list of all users
	@GetMapping("/")
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	// displaying user by id
	@GetMapping("/{id}")
	public User getUser(@PathVariable UUID id) {
		return userService.getUser(id);
	}

	// inserting user
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addUsers(@RequestBody User user) {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}

	// updating user by id
	@PutMapping("/{id}")
	public void updateUser(@RequestBody User e, @PathVariable UUID id) {
		userService.updateUser(e, id);
	}

	// deleting all users
	@DeleteMapping("/")
	public void deleteAllUsers() {
		userService.deleteAllUsers();
	}

	// deleting user by id
	@DeleteMapping("/{id}")
	public void deleteUserByID(@RequestBody User e, @PathVariable UUID id) {
		userService.deleteUserByID(id);
	}

	// updating/ patching user by id
	@PatchMapping("/{id}")
	public void patchUserByID(@RequestBody User e, @PathVariable UUID id) {
		userService.patchUser(e, id);
	}
}
