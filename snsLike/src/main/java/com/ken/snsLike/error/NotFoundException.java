package com.ken.snsLike.error;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundException(UUID id) {
		super("ID: " + id + "は見つかりませんでした");
	}
}
