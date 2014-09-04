package com.mediasilo.sdk.rest.credentials;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class BasicAuthenticationCredentials extends AbstractCredentials {

	private String username;
	private String password;

	public BasicAuthenticationCredentials(String username, String password, String hostName) {
		super(hostName);
		this.username = username;
		this.password = password;
	}


	public String encodeForBasicAuth() {
		String encodedCredentials = Base64.encode(String.format("%s:%s", username, password).getBytes());

		return String.format("Basic %s", encodedCredentials);
	}

}
