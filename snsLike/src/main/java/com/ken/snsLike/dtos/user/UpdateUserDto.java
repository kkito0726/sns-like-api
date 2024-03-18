package com.ken.snsLike.dtos.user;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {

	private String email;

	@Length(min = 7)
	private String password;

	@Length(max = 20)
	private String displayName;
}
