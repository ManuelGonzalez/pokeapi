package com.manuel.pokeapi.domain.storage;

import com.manuel.pokeapi.common.ErrorLogger;

public class ErrorStorage extends ErrorLogger {

	public ErrorStorage(String message, String detail) {
		super(message, detail);
	}

	public String getErrorType() {
		return TYPE.STORAGE.name();
	}

}
