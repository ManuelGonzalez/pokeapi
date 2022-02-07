package com.credicoop.pitagora.domain.services;

import com.credicoop.pitagora.common.ErrorLogger;

public class ErrorService extends ErrorLogger {

	public ErrorService(String message, String detail) {
		super(message, detail);
	}

	public String getErrorType() {
		return TYPE.STORAGE.name();
	}

}
