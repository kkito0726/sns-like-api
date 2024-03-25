package com.ken.snsLike.service;

import com.ken.snsLike.dtos.comment.CommentDto;
import com.ken.snsLike.dtos.comment.CreateCommentDto;
import com.ken.snsLike.dtos.comment.UpdateCommentDto;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<CommentDto> getComments();
    CommentDto getCommentByCommentId(UUID commentId);
    CommentDto createComment(CreateCommentDto comment);
    CommentDto updateComment(UUID commentId, UpdateCommentDto comment);
    CommentDto deleteComment(UUID commentId);
}
