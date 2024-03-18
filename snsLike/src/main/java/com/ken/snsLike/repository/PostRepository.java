package com.ken.snsLike.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.ken.snsLike.models.Post;

public interface PostRepository extends CrudRepository<Post, UUID> {

}
