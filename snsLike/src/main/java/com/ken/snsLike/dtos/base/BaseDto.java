package com.ken.snsLike.dtos.base;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
