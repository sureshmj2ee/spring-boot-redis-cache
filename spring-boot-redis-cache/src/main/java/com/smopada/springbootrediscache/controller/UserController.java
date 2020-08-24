package com.smopada.springbootrediscache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smopada.springbootrediscache.model.User;
import com.smopada.springbootrediscache.repository.RedisUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	RedisUserRepository repository;

	@PostMapping()
	public User save(@RequestBody User user) {
		repository.save(user);
		return user;
	}

	@GetMapping()
	public List<User> list() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		return repository.findById(id);
	}

	@PutMapping()
	public User updateUser(@RequestBody User user) {
		repository.update(user);
		return user;
	}

	@DeleteMapping("/{id}")
	public Integer deleteUser(@PathVariable Integer id) {
		repository. delete(id);
		return id;
	}
}
