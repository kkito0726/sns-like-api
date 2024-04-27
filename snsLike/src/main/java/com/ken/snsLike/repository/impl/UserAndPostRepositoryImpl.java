package com.ken.snsLike.repository.impl;

import com.ken.snsLike.entity.PostResponseEntity;
import com.ken.snsLike.repository.UserAndPostRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class UserAndPostRepositoryImpl implements UserAndPostRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<PostResponseEntity> selectPostsByUserId(UUID userId) {

    List<PostResponseEntity> results = entityManager.createNativeQuery(
                "SELECT u.user_id, u.display_name, p.title, p.body, p.created_at FROM user as u RIGHT OUTER JOIN post as p ON u.user_id = p.user_id WHERE u.user_id = :user_id",
                PostResponseEntity.class
        )
                .setParameter("user_id", userId)
                .getResultList();
        return results;
    }
}
