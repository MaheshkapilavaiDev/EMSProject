package com.employyemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.employyemanagementsystem.entity.User;
import com.employyemanagementsystem.repository.UserRepository;
import com.employyemanagementsystem.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepository repo;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/register")
	public String register(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return "User registered";
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		User dbUser = repo.findByUserName(user.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

		if (!encoder.matches(user.getPassword(), dbUser.getPassword())) {
			throw new RuntimeException("Invalid password");
		}

		return jwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole());
	}

}
