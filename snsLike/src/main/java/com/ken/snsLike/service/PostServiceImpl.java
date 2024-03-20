package com.ken.snsLike.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ken.snsLike.dtos.post.CreatePostDto;
import com.ken.snsLike.dtos.post.PostDto;
import com.ken.snsLike.dtos.post.UpdatePostDto;
import com.ken.snsLike.error.NotFoundException;
import com.ken.snsLike.mapper.PostMapper;
import com.ken.snsLike.models.Post;
import com.ken.snsLike.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostMapper postMapper;

	@Override
	public List<PostDto> getPosts() {
		List<PostDto> posts = new ArrayList<PostDto>();
		postRepository.findAll().forEach(post -> posts.add(postMapper.toDto(post)));
		return posts;
	}

	@Override
	public PostDto getPostByPostId(UUID postId) {
		return postMapper.toDto(_findPost(postId));
	}

	@Override
	public PostDto createPost(CreatePostDto post) {
		Post newPost = postMapper.createPostToEntity(post);
		Post savePost = postRepository.save(newPost);
		return postMapper.toDto(savePost);
	}

	@Override
	public PostDto updatePost(UUID postId, UpdatePostDto post) {
		Post found = _findPost(postId);

		if (Objects.nonNull(post.getTitle())) {
			found.setTitle(post.getTitle());
		}

		if (Objects.nonNull(post.getBody())) {
			found.setBody(post.getBody());
		}

		Post updatePost = postRepository.save(found);
		return postMapper.toDto(updatePost);
	}

	@Override
	public PostDto deletePost(UUID postId) {
		Post found = _findPost(postId);
		postRepository.deleteById(postId);
		return postMapper.toDto(found);
	}

	private Post _findPost(UUID postId) {
		Optional<Post> found = postRepository.findById(postId);
		if (found.isEmpty()) {
			throw new NotFoundException(postId);
		}
		return found.get();
	}
}
