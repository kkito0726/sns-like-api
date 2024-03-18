package com.ken.snsLike.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ken.snsLike.dtos.post.CreatePostDto;
import com.ken.snsLike.dtos.post.PostDto;
import com.ken.snsLike.models.Post;

@Component
public class PostMapper {
	@Autowired
	private ModelMapper modelMapper;

	public PostDto toDto(Post entity) {
		return modelMapper.map(entity, PostDto.class);
	}

	public Post toEntity(PostDto dto) {
		return modelMapper.map(dto, Post.class);
	}

	public Post createPostToEntity(CreatePostDto dto) {
		return modelMapper.map(dto, Post.class);
	}
}
