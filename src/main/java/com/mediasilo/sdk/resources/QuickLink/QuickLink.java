package com.mediasilo.sdk.resources.QuickLink;

import com.mediasilo.sdk.resources.QuickLink.model.QuickLinkConfiguration;
import com.mediasilo.sdk.rest.resource.CreateResponse;
import com.mediasilo.sdk.rest.resource.MediaSiloResourceException;
import com.mediasilo.sdk.rest.resource.Resource;
import com.mediasilo.sdk.rest.client.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Resource class for QuickLinks
 */
public class QuickLink extends Resource<QuickLinkRequest, QuickLinkResponse> {

	public QuickLink(RestClient restClient) {
		super(restClient, QuickLinkRequest.class, QuickLinkResponse.class);
	}

	/**
	 * Represents the resource path in the MediaSilo API
	 * @return
	 */
	protected String getResourcePath() {
		return "quicklinks";
	}

	/**
	 * Creates a new QuickLink from a fully hydrated QuickLinkRequest object
	 * @param request A QuickLinkRequest object
	 * @return A response containing the ID of the newly created QuickLink
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(QuickLinkRequest request) throws MediaSiloResourceException {
		return super.create(request, "");
	}

	/**
	 * Creates a new QuickLink
	 * @param title The title of the new QuickLink. This will appear as a header in the QuickLink web app
	 * @param description The text that describrs the contents of the QuickLink to be displayed in the QuickLink web app
	 * @param assetIds A list of asset identifiers to be contained in the QuickLink
	 * @return A response containing the ID of the newly created QuickLink
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(String title, String description, String... assetIds) throws MediaSiloResourceException {
		List<String> assetIdList = new ArrayList<String>();

		for(String assetId : assetIds) {
			assetIdList.add(assetId);
		}

		return create(new QuickLinkRequest(title, description, assetIdList));
	}

	/**
	 * Creates a new QuickLink
	 * @param title The title of the new QuickLink. This will appear as a header in the QuickLink web app
	 * @param description The text that describrs the contents of the QuickLink to be displayed in the QuickLink web app
	 * @param configuration Key/Value pairs the define the setting of the QuickLink
	 * @param assetIds A list of asset identifiers to be contained in the QuickLink
	 * @return A response containing the ID of the newly created QuickLink
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(String title, String description, HashMap<String, String> configuration, String... assetIds) {
		List<String> assetIdList = new ArrayList<String>();

		for(String assetId : assetIds) {
			assetIdList.add(assetId);
		}

		QuickLinkConfiguration quickLinkConfiguration = new QuickLinkConfiguration();

		if(configuration != null) {
			quickLinkConfiguration = new QuickLinkConfiguration(configuration);
		}

		return create(new QuickLinkRequest(title, description, assetIdList, quickLinkConfiguration, 0L));
	}

	/**
	 * Get a specific QuickLink by it's ID
	 * @param id The identifier of the QuickLink to retrieve
	 * @return A QuickLinkResponse
	 * @throws MediaSiloResourceException
	 */
	public QuickLinkResponse read(String id) throws MediaSiloResourceException {
		return get(id, "");
	}

	/**
	 * Update a QuickLink
	 * @param request A QuickLinkRequest representing the changes to be made. NOTE: This object should have the ID
	 *                   of the target QuickLink set otherwise no update will be performed.
	 * @throws MediaSiloResourceException
	 */
	public void update(QuickLinkRequest request) throws MediaSiloResourceException {
		super.update(request, "");
	}
}
