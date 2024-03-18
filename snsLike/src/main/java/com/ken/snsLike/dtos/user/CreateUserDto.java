package com.ken.snsLike.dtos.user;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

	@NotNull
	private String email;

	@NotNull
	@Length(min = 7)
	private String password;

	@NotNull
	@Length(max = 20)
	private String displayName;
}
