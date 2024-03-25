package com.ken.snsLike.controller;

import com.ken.snsLike.dtos.comment.CommentDto;
import com.ken.snsLike.dtos.comment.CreateCommentDto;
import com.ken.snsLike.dtos.comment.UpdateCommentDto;
import com.ken.snsLike.repository.CommentRepository;
import com.ken.snsLike.service.CommentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public List<CommentDto> getComments() {
        return commentService.getComments();
    }

    @GetMapping("/comment/{commentId}")
    public CommentDto getComment(@PathVariable UUID commentId) {
        return commentService.getCommentByCommentId(commentId);
    }

    @PostMapping("/comment")
    public CommentDto createComment(@RequestBody CreateCommentDto dto) {
        return commentService.createComment(dto);
    }

    @PutMapping("/comment/{commentId}")
    public CommentDto updateComment(@PathVariable UUID commentId, @RequestBody UpdateCommentDto dto) {
        return commentService.updateComment(commentId, dto);
    }

    @DeleteMapping("/comment/{commentId}")
    public  CommentDto deleteComment(@PathVariable UUID commentId) {
        return  commentService.deleteComment(commentId);    
    }
}
