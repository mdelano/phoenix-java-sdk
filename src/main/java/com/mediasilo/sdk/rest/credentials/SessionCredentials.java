package com.mediasilo.sdk.rest.credentials;


public class SessionCredentials extends AbstractCredentials {

	private String sessionKey;

	public SessionCredentials(String sessionKey, String hostName) {
		super(hostName);
		this.sessionKey = sessionKey;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
}
