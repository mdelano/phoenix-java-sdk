package com.mediasilo.sdk.rest.client;

import org.apache.http.HttpResponse;

public class MediaSiloRestClientException extends RestClientException {

	public MediaSiloRestClientException() {
		super();
	}

	public MediaSiloRestClientException(String message) {
		super(message);
	}

	public MediaSiloRestClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public MediaSiloRestClientException(Throwable cause) {
		super(cause);
	}

	public MediaSiloRestClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MediaSiloRestClientException(String message, HttpResponse resp) {
		super(message);
		response = resp;
	}

	public MediaSiloRestClientException(String message, Throwable t, HttpResponse resp) {
		super(message, t);
		response = resp;
	}
}
