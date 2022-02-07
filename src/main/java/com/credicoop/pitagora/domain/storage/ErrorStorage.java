package com.credicoop.pitagora.domain.storage;

import com.credicoop.pitagora.common.ErrorLogger;

public class ErrorStorage extends ErrorLogger {

	public ErrorStorage(String message, String detail) {
		super(message, detail);
	}

	public String getErrorType() {
		return TYPE.STORAGE.name();
	}

}
