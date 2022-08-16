package com.credicoop.pitagora.domain.services;

import lombok.Getter;

public class ServiceException extends Exception {

	@Getter
	public static enum Type {
		REMOTE_DISPOSITIVE_FAILED;
	};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3933048067819522188L;

	public ServiceException() {
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression,
							boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceException(ErrorService errorStorage) {
		super(errorStorage.toString());
	}

}
