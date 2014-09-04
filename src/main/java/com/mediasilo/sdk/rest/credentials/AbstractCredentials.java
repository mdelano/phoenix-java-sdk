package com.mediasilo.sdk.rest.credentials;

public abstract class AbstractCredentials implements Credentials {

	protected String hostName;

	protected AbstractCredentials() {}

	protected AbstractCredentials(String hostName) {
		this.hostName = hostName;
	}

	public String getHostName() {
		return hostName;
	}
}
