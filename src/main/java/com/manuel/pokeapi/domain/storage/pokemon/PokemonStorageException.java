package com.manuel.pokeapi.domain.storage.pokemon;

import com.manuel.pokeapi.domain.storage.ErrorStorage;
import com.manuel.pokeapi.domain.storage.StorageException;

public class PokemonStorageException extends StorageException {

	private static final long serialVersionUID = -7961852153520535578L;
	
	public static final String REMOTE_DISPOSITIVE_FAILED = "Remote dispositive failed!";
	
	public PokemonStorageException(ErrorStorage errorStorage) {
		super(errorStorage);
	}
	
}
