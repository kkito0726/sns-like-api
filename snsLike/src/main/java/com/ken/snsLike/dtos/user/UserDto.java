package com.ken.snsLike.dtos.user;

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
public class UserDto extends BaseDto {
	private UUID userId;

	private String email;

	private String displayName;

}
