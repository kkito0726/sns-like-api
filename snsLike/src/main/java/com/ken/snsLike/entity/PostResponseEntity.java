package com.ken.snsLike.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseEntity {
    private String displayName;
    private String title;
    private String body;
    private LocalDateTime createdAt;
}
