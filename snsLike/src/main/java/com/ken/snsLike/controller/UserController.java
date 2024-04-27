package com.ken.snsLike.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ken.snsLike.dtos.user.CreateUserDto;
import com.ken.snsLike.dtos.user.UpdateUserDto;
import com.ken.snsLike.dtos.user.UserDto;
import com.ken.snsLike.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public ResponseEntity<List<UserDto>> getMethodName() {
		return ResponseEntity.ok(userService.getUsers());
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDto> getMethodName(@PathVariable("userId") UUID userId) {
		return ResponseEntity.ok(userService.getUserByUserId(userId));
	}

	@PostMapping("/user")
	public ResponseEntity<UserDto> postMethodName(@RequestBody CreateUserDto entity) {
		return ResponseEntity.ok(userService.createUser(entity));
	}

	@PutMapping("/user/{userId}")
	public ResponseEntity<UserDto> putMethodName(@PathVariable("userId") UUID userId,
			@RequestBody UpdateUserDto entity) {
		return ResponseEntity.ok(userService.updateUser(userId, entity));
	}

	@DeleteMapping("/user/userId")
	public ResponseEntity<UserDto> deleteUser(@PathVariable("userId") UUID userId) {
		return ResponseEntity.ok(userService.deleteUser(userId));
	}

}
