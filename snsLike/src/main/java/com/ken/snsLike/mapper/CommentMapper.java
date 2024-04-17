package com.ken.snsLike.mapper;

import com.ken.snsLike.dtos.comment.CommentDto;
import com.ken.snsLike.dtos.comment.CreateCommentDto;
import com.ken.snsLike.models.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

	@Autowired
	private ModelMapper modelMapper;

	public CommentDto toDto(Comment entity) {
		return modelMapper.map(entity, CommentDto.class);
	}

	public Comment createToEntity(CreateCommentDto dto) {
		return modelMapper.map(dto, Comment.class);
	}
}
