package com.ken.snsLike.dtos.comment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommentDto {
    @NotNull
    private UUID commentID;
    @NotNull
    private UUID authorId;
    private String comment;
}
