package com.ken.snsLike.service;

import java.util.List;
import java.util.UUID;

import com.ken.snsLike.dtos.post.CreatePostDto;
import com.ken.snsLike.dtos.post.PostDto;
import com.ken.snsLike.dtos.post.UpdatePostDto;

public interface PostService {

	List<PostDto> getPosts();

	PostDto getPostByPostId(UUID postId);

	PostDto createPost(CreatePostDto post);

	PostDto updatePost(UUID postId, UpdatePostDto post);

	PostDto deletePost(UUID postId);
}
