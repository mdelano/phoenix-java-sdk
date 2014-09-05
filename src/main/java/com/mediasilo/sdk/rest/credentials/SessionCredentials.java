package com.mediasilo.sdk.rest.credentials;


public class SessionCredentials extends AbstractCredentials {

	private String sessionKey;

	public SessionCredentials(String sessionKey, String hostName) {
		super(hostName);
		this.sessionKey = sessionKey;
	}

}
