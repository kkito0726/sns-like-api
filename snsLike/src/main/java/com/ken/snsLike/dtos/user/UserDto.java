package com.ken.snsLike.dtos.user;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private UUID userId;

	private String email;

	private String displayName;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
}
