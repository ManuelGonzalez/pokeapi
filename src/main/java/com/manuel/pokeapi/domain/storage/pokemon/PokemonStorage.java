package com.manuel.pokeapi.domain.storage.pokemon;

import com.manuel.pokeapi.domain.storage.ErrorStorage;
import com.manuel.pokeapi.dto.PokemonDto;
import com.manuel.pokeapi.dto.PokemonMinResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException.NotFound;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Slf4j
@Service
public class PokemonStorage {

	@Value("${apis.pokeapi.uriTemplate}")
	private String pokeApiUrl;

	@Value("${apis.pokeapi.uriTemplateWithId}")
	private String pokeApiUrlWithId;

	private final WebClient webClient;

	@Autowired
	public PokemonStorage(WebClient webClient) {
		this.webClient = webClient;
	}

	public Optional<PokemonDto> findById(String id) throws PokemonStorageException {

		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);

		UriComponents uri = UriComponentsBuilder.fromUriString(pokeApiUrlWithId).buildAndExpand(param);

		try {

			return Optional.ofNullable(this.webClient.get().uri(uri.toUri()).headers(headers -> {
				headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
				headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			}).retrieve().bodyToMono(PokemonDto.class).block());

		} catch (NotFound e) {
			String message = id.concat(" not found");
			ErrorStorage error = new ErrorStorage(message, e.getMessage());
			log.error(error.toString());
			return Optional.empty();
		} catch (Exception e) {
			ErrorStorage error = new ErrorStorage(PokemonStorageException.REMOTE_DISPOSITIVE_FAILED, e.getMessage());
			log.error(error.toString());
			throw new PokemonStorageException(error);
		}

	}

	public Optional<PokemonDto> findByUrl(String url) throws PokemonStorageException {

		UriComponents uri = UriComponentsBuilder.fromUriString(url).build();

		try {

			return Optional.ofNullable(this.webClient.get().uri(uri.toUri()).headers(headers -> {
				headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
				headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			}).retrieve().bodyToMono(PokemonDto.class).block());

		} catch (NotFound e) {
			String message = url.concat(" not found");
			ErrorStorage error = new ErrorStorage(message, e.getMessage());
			log.error(error.toString());
			return Optional.empty();
		} catch (Exception e) {
			ErrorStorage error = new ErrorStorage(PokemonStorageException.REMOTE_DISPOSITIVE_FAILED, e.getMessage());
			log.error(error.toString());
			throw new PokemonStorageException(error);
		}

	}

	public Optional<PokemonMinResponseDto> findAllBasicInfo(String limit, String offset) throws PokemonStorageException {

		log.info("getting info of the pokeapi service");

		UriComponents uri = UriComponentsBuilder.fromUriString(pokeApiUrl)
				.queryParam("limit", limit)
				.queryParam("offset", offset)
				.build();

		log.info("GET -> ".concat(uri.toString()));

		try {

			return Optional.ofNullable(this.webClient.get().uri(uri.toUri()).headers(headers -> {
				headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
				headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			}).retrieve().bodyToMono(PokemonMinResponseDto.class).block());

		} catch (Exception e) {
			ErrorStorage error = new ErrorStorage(PokemonStorageException.REMOTE_DISPOSITIVE_FAILED, e.getMessage());
			log.error(error.toString());
			throw new PokemonStorageException(error);
		}

	}

}
