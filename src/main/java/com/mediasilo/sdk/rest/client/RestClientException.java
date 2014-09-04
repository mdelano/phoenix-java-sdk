package com.mediasilo.sdk.rest.client;

import org.apache.http.HttpResponse;

public class RestClientException extends RuntimeException {

	public HttpResponse response;

	public RestClientException() {}

	public RestClientException(String message) {
		super(message);
	}

	public RestClientException(Throwable cause) {
		super(cause);
	}

	public RestClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RestClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestClientException(String message, HttpResponse resp) {
		super(message);
		response = resp;
	}

	public RestClientException(String message, Throwable t, HttpResponse resp) {
		super(message, t);
		response = resp;
	}
}
