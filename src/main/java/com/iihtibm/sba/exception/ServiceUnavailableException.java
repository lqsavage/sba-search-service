package com.iihtibm.sba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author savagelee
 */
@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Exception ex;

	public ServiceUnavailableException(String message) {
		super(message);
	}

	public ServiceUnavailableException(Exception e, String message) {
		super(message);
		ex = e;
	}

	public Exception getEx() {
		return ex;
	}
}
