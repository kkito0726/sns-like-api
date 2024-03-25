package com.ken.snsLike.models;


import com.ken.snsLike.models.base.EntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "comment")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends EntityBase {
    @Id
    @Column(name = "comment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID commentId;

    @Column(name = "post_id", nullable = false)
    private UUID postId;
    @Column(name = "author_id", nullable = false)
    private UUID authorId;
    @Column(name = "comment")
    private String comment;
}
