package com.mediasilo.sdk;

import com.mediasilo.sdk.resources.QuickLink.QuickLink;
import com.mediasilo.sdk.rest.credentials.BasicAuthenticationCredentials;
import com.mediasilo.sdk.rest.credentials.Credentials;
import com.mediasilo.sdk.rest.client.MediaSiloRestClient;
import com.mediasilo.sdk.rest.client.RestClient;

/**
 * This is the wrapper class for the MediaSilo API. It contains all of the services available to MediaSilo
 *
 * MediaSilo
 *
 * Mike Delano
 */
public class MediaSiloSdk {

	private RestClient restClient;

	private QuickLink quickLink;


	protected static class SingletonHolder {
		public static final MediaSiloSdk INSTANCE = new MediaSiloSdk();
	}

	public static MediaSiloSdk getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Initializes the SDK by setting the authentication. This method support Basic
	 * Authentication to the MediaSilo REST API. The SDK must be initialized before
	 * any calls are made to it.
	 *
	 * @param username
	 * @param password
	 * @param hostname
	 */
	public void init(String username, String password, String hostname) {
		Credentials credentials = new BasicAuthenticationCredentials(username, password, hostname);
		restClient = new MediaSiloRestClient("http://127.0.0.1:9001/v3", credentials);
	}

	/**
	 * QuickLinks are one of MediaSilo's primary mechanisms for sharing assets with a designated audience through
	 * a specialized client application. QuickLinks contain one or more Assets which can be shared publicly (with
	 * or without a password) and privately (with other MediaSilo users on your account). QuickLinks contain a
	 * configuration which encapsulates a list of Settings relevant to the QuickLink. Additionally, you can send
	 * a QuickLink to a specified audience through our Shares endpoint.
	 *
	 * @see: http://developers.mediasilo.com/quicklinks
	 * @return
	 */
	public QuickLink quicklinks() {
		if(quickLink == null) {
			quickLink = new QuickLink(restClient);
		}

		return quickLink;
	}

}
