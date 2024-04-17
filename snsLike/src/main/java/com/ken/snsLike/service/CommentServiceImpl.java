package com.ken.snsLike.service;

import com.ken.snsLike.dtos.comment.CommentDto;
import com.ken.snsLike.dtos.comment.CreateCommentDto;
import com.ken.snsLike.dtos.comment.UpdateCommentDto;
import com.ken.snsLike.error.NotFoundException;
import com.ken.snsLike.mapper.CommentMapper;
import com.ken.snsLike.models.Comment;
import com.ken.snsLike.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDto> getComments() {
        List<CommentDto> comments = new ArrayList<CommentDto>();
        commentRepository.findAll().forEach(comment -> comments.add(commentMapper.toDto(comment)));

        return comments;
    }

    @Override
    public CommentDto getCommentByCommentId(UUID commentId) {
        Comment comment = _findComment(commentId);
        return commentMapper.toDto(comment);
    }

    @Override
    public CommentDto createComment(CreateCommentDto comment) {
        Comment entity = commentMapper.createToEntity(comment);
        Comment saveComment = commentRepository.save(entity);
        return commentMapper.toDto(saveComment);
    }

    @Override
    public CommentDto updateComment(UUID commentId, UpdateCommentDto comment) {
        Comment found = _findComment(commentId);

        if (Objects.nonNull(comment.getComment())) {
            found.setComment(comment.getComment());
        }
        Comment saveComment = commentRepository.save(found);
        return commentMapper.toDto(saveComment);
    }

    @Override
    public CommentDto deleteComment(UUID commentId) {
        Comment found = _findComment(commentId);
        commentRepository.deleteById(commentId);
        return commentMapper.toDto(found);
    }

    private Comment _findComment(UUID commentId) {
        Optional<Comment> found = commentRepository.findById(commentId);

        if (found.isEmpty()) {
            throw new NotFoundException("Not Found this ID = " + commentId);
        }

        return found.get();
    }
}
