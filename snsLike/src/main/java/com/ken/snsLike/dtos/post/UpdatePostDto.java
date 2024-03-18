package com.ken.snsLike.dtos.post;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostDto {

	private UUID userId;
	@Length(max = 30)
	private String title;
	private String body;
}
