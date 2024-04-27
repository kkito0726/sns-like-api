package com.ken.snsLike.repository;

import com.ken.snsLike.entity.PostResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserAndPostRepository {

    List<PostResponseEntity> selectPostsByUserId(UUID user_id);
}
