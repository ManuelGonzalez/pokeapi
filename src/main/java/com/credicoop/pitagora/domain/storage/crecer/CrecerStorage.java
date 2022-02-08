package com.credicoop.pitagora.domain.storage.crecer;

import com.credicoop.pitagora.domain.storage.ErrorStorage;
import com.credicoop.pitagora.dto.CrecerResponseDto;
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
import java.util.stream.Collectors;

@Slf4j
@Service
public class CrecerStorage {

	@Value("${apis.crecer.uriTemplate}")
	private String crecerUrl;

	private final WebClient webClient;

	@Autowired
	public CrecerStorage(WebClient webClient) {
		this.webClient = webClient;
	}

	public Optional<CrecerResponseDto> findById(String clientId, String path) throws CrecerStorageException {

		Map<String, String> param = new HashMap<String, String>();
		param.put("id", clientId);
		param.put("path", path);

		UriComponents uri = UriComponentsBuilder.fromUriString(crecerUrl).buildAndExpand(param);

		try {

			return Optional.ofNullable(this.webClient.get().uri(uri.toUri()).headers(headers -> {
				headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
				headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			}).retrieve().bodyToMono(CrecerResponseDto.class).block());

		} catch (NotFound e) {
			String message = clientId.concat(" not found");
			ErrorStorage error = new ErrorStorage(message, e.getMessage());
			log.error(error.toString());
			return Optional.empty();
		} catch (Exception e) {
			ErrorStorage error = new ErrorStorage(CrecerStorageException.REMOTE_DISPOSITIVE_FAILED, e.getMessage());
			log.error(error.toString());
			throw new CrecerStorageException(error);
		}

	}

}
