package com.ken.snsLike.dtos.comment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentDto {
    @NotNull
    private UUID postId;
    @NotNull
    private UUID authorId;
    @NotNull
    private String comment;

}
