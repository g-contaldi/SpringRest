package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.config.security.service.AuthService;
import it.dstech.model.User;
import it.dstech.service.UserService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public User authenticate(@RequestBody User principal) throws Exception {
		authService.authenticate(principal);
		return principal;
	}

	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/getUserModel")
	public User getModel() {
		return new User();
	}

}
