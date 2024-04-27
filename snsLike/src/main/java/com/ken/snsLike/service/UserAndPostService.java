package com.ken.snsLike.service;

import com.ken.snsLike.entity.PostResponseEntity;
import com.ken.snsLike.repository.UserAndPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserAndPostService {
    @Autowired private UserAndPostRepository userAndPostRepository;

    public List<PostResponseEntity> getPosts(UUID userId) {
        return  userAndPostRepository.selectPostsByUserId(userId);
    }
}
