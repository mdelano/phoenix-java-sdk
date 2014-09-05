package com.mediasilo.sdk.resources.share;

import com.mediasilo.sdk.rest.client.RestClient;
import com.mediasilo.sdk.rest.resource.CreateResponse;
import com.mediasilo.sdk.rest.resource.MediaSiloResourceException;
import com.mediasilo.sdk.rest.resource.Resource;

/**
 * Resource class for QuickLinks
 */
public class Share extends Resource<ShareRequestResponse, ShareRequestResponse> {

	public Share(RestClient restClient) {
		super(restClient, ShareRequestResponse.class, ShareRequestResponse.class);
	}

	/**
	 * Represents the resource path in the MediaSilo API
	 * @return
	 */
	protected String getResourcePath() {
		return "shares";
	}

	/**
	 * Creates a new Share from a fully hydrated ShareRequestResponse object
	 * @param request A ShareRequestResponse object
	 * @return A response containing the ID of the newly created Share
	 * @throws com.mediasilo.sdk.rest.resource.MediaSiloResourceException
	 */
	public CreateResponse create(ShareRequestResponse request) throws MediaSiloResourceException {
		return super.create(request, "");
	}

	/**
	 * Creates a new Share
	 * @param targetObjectId The identifier of the object that is being shares. For example, a QuickLink id
	 * @param emailAddress The recipient of the share
	 * @return
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(String targetObjectId, String emailAddress) throws MediaSiloResourceException {
		ShareRequestResponse shareRequestResponse = new ShareRequestResponse(targetObjectId, emailAddress);

		return create(shareRequestResponse);
	}

	/**
	 * Creates a new Share
	 * @param targetObjectId The identifier of the object that is being shares. For example, a QuickLink id
	 * @param subject The subject of the share message
	 * @param message The message the recipient will receive with the share
	 * @param emailAddresses The recipients of the share
	 * @return
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(String targetObjectId, String subject, String message,
								 String... emailAddresses) throws
			MediaSiloResourceException {
		ShareRequestResponse shareRequestResponse = new ShareRequestResponse(targetObjectId, subject, message, emailAddresses);

		return create(shareRequestResponse);
	}
}
