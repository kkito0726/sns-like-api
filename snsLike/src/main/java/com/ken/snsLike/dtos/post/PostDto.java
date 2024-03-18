package com.ken.snsLike.dtos.post;

import java.util.UUID;

import com.ken.snsLike.dtos.base.BaseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PostDto extends BaseDto {
	private UUID postId;
	private UUID userId;
	private String title;
	private String body;
}
