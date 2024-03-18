package com.ken.snsLike.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ken.snsLike.dtos.user.CreateUserDto;
import com.ken.snsLike.dtos.user.UserDto;
import com.ken.snsLike.models.User;

@Component
public class UserMapper {
	@Autowired
	public ModelMapper modelMapper;

	public UserDto toDto(User entity) {
		return modelMapper.map(entity, UserDto.class);
	}

	public User toEntity(UserDto dto) {
		return modelMapper.map(dto, User.class);
	}

	public User createToEntity(CreateUserDto dto) {
		return modelMapper.map(dto, User.class);
	}
}
