package com.credicoop.pitagora.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ErrorLogger {

	public static enum TYPE {
		DOMAIN, STORAGE, CONTROLLER
	}

	private String message;
	private String detail;

	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "Object to Json failed!";
		}
	}
	
	public abstract String getErrorType();

}
