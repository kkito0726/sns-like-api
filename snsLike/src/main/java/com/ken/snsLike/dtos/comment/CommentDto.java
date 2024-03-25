package com.ken.snsLike.dtos.comment;

import com.ken.snsLike.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto extends BaseDto {

    private UUID commentId;
    private UUID postId;
    private UUID userId;
    private UUID authorId;
    private String comment;
}
