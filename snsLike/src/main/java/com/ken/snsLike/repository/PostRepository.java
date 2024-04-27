package com.ken.snsLike.repository;

import java.util.List;
import java.util.UUID;

import com.ken.snsLike.entity.PostResponseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ken.snsLike.models.Post;

public interface PostRepository extends CrudRepository<Post, UUID>  {

}
