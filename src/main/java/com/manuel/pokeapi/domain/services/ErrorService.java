package com.manuel.pokeapi.domain.services;

import com.manuel.pokeapi.common.ErrorLogger;

public class ErrorService extends ErrorLogger {

	public ErrorService(String message, String detail) {
		super(message, detail);
	}

	public String getErrorType() {
		return TYPE.STORAGE.name();
	}

}
