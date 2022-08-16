package com.manuel.pokeapi.domain.storage;

import lombok.Getter;

public class StorageException extends Exception {

	@Getter
	public static enum Type {
		REMOTE_DISPOSITIVE_FAILED;
	};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3933048067819522188L;

	public StorageException() {
		// TODO Auto-generated constructor stub
	}

	public StorageException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StorageException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StorageException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public StorageException(ErrorStorage errorStorage) {
		super(errorStorage.toString());
	}

}
