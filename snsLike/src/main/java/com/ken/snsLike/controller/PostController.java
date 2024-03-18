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

import com.ken.snsLike.dtos.post.CreatePostDto;
import com.ken.snsLike.dtos.post.PostDto;
import com.ken.snsLike.dtos.post.UpdatePostDto;
import com.ken.snsLike.service.PostService;

@RestController
public class PostController {
	@Autowired
	private PostService postService;

	@GetMapping("/post")
	public ResponseEntity<List<PostDto>> getPosts() {
		return ResponseEntity.ok(postService.getPosts());
	}

	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable("postId") UUID postId) {
		return ResponseEntity.ok(postService.getPostByPostId(postId));
	}

	@PostMapping("/post")
	public ResponseEntity<PostDto> createPost(@RequestBody CreatePostDto dto) {
		return ResponseEntity.ok(postService.createPost(dto));
	}

	@PutMapping("post/{postId}")
	public ResponseEntity<PostDto> putMethodName(@PathVariable UUID postId, @RequestBody UpdatePostDto dto) {
		return ResponseEntity.ok(postService.updatePost(postId, dto));
	}

	@DeleteMapping("/post/{postId}")
	public ResponseEntity<PostDto> deletePost(@PathVariable UUID postId) {
		return ResponseEntity.ok(postService.deletePost(postId));
	}

}
