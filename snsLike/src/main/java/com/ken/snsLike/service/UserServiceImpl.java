package com.ken.snsLike.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ken.snsLike.dtos.user.CreateUserDto;
import com.ken.snsLike.dtos.user.UpdateUserDto;
import com.ken.snsLike.dtos.user.UserDto;
import com.ken.snsLike.error.NotFoundException;
import com.ken.snsLike.mapper.UserMapper;
import com.ken.snsLike.models.User;
import com.ken.snsLike.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserDto> getUsers() {
		// TODO 自動生成されたメソッド・スタブ
		List<UserDto> users = new ArrayList<UserDto>();
		userRepository.findAll().forEach(user -> users.add(userMapper.toDto(user)));
		return users;
	}

	@Override
	public UserDto getUserByUserId(UUID userId) {
		User user = _findUserById(userId);
		return userMapper.toDto(user);
	}

	@Override
	public UserDto createUser(CreateUserDto user) {
		User createUser = userMapper.createToEntity(user);
		User saveUser = userRepository.save(createUser);
		return userMapper.toDto(saveUser);
	}

	@Override
	public UserDto updateUser(UUID userId, UpdateUserDto user) {
		User found = _findUserById(userId);
		if (Objects.nonNull(user.getEmail())) {
			found.setEmail(user.getEmail());
		}
		if (Objects.nonNull(user.getPassword())) {
			found.setPassword(user.getPassword());
		}
		if (Objects.nonNull(user.getDisplayName())) {
			found.setDisplayName(user.getDisplayName());
		}
		User updateUser = userRepository.save(found);
		return userMapper.toDto(updateUser);
	}

	@Override
	public UserDto deleteUser(UUID userId) {
		// TODO 自動生成されたメソッド・スタブ
		UserDto userDto = getUserByUserId(userId);
		userRepository.deleteById(userId);
		return userDto;
	}

	private User _findUserById(UUID userId) {
		Optional<User> found = userRepository.findById(userId);
		if (found.isEmpty()) {
			throw new NotFoundException(userId);
		}
		return found.get();
	}
}
