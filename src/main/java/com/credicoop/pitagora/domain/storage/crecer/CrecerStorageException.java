package com.credicoop.pitagora.domain.storage.crecer;

import com.credicoop.pitagora.domain.storage.ErrorStorage;
import com.credicoop.pitagora.domain.storage.StorageException;

public class CrecerStorageException extends StorageException {

	private static final long serialVersionUID = -7961852153520535578L;
	
	public static final String REMOTE_DISPOSITIVE_FAILED = "Remote dispositive failed!";
	
	public CrecerStorageException(ErrorStorage errorStorage) {
		super(errorStorage);
	}
	
}
