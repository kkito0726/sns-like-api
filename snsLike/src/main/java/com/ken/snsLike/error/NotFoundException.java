package com.ken.snsLike.error;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class NotFoundException extends HttpException {
	public NotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause, HttpStatus.NOT_FOUND);
	}

	public NotFoundException(Throwable cause) {
		super(cause, HttpStatus.NOT_FOUND);
	}

	public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace, HttpStatus.NOT_FOUND);
	}
}
