package com.ken.snsLike.service;

import java.util.List;
import java.util.UUID;

import com.ken.snsLike.dtos.user.CreateUserDto;
import com.ken.snsLike.dtos.user.UpdateUserDto;
import com.ken.snsLike.dtos.user.UserDto;

public interface UserService {
	List<UserDto> getUsers();

	UserDto getUserByUserId(UUID userId);

	UserDto createUser(CreateUserDto user);

	UserDto updateUser(UUID userId, UpdateUserDto user);

	UserDto deleteUser(UUID userId);

}
