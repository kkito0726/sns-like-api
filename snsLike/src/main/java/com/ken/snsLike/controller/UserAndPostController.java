package com.ken.snsLike.controller;

import com.ken.snsLike.entity.PostResponseEntity;
import com.ken.snsLike.service.UserAndPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserAndPostController {
    @Autowired private UserAndPostService userAndPostService;

    @GetMapping("/user_post/{user_id}")
    public List<PostResponseEntity> getPosts(@PathVariable("user_id") UUID userId) {
        return userAndPostService.getPosts(userId);
    }
}
