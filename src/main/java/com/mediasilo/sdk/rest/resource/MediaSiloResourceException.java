package com.mediasilo.sdk.rest.resource;

import org.apache.http.HttpResponse;

public class MediaSiloResourceException extends RuntimeException {

	public HttpResponse response;

	public MediaSiloResourceException() {}

	public MediaSiloResourceException(String message) {
		super(message);
	}

	public MediaSiloResourceException(Throwable cause) {
		super(cause);
	}

	public MediaSiloResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MediaSiloResourceException(String message, Throwable cause) {
		super(message, cause);
	}
}
