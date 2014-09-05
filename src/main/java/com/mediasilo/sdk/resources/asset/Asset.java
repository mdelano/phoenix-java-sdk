package com.mediasilo.sdk.resources.asset;

import com.mediasilo.sdk.rest.client.RestClient;
import com.mediasilo.sdk.rest.resource.CreateResponse;
import com.mediasilo.sdk.rest.resource.MediaSiloResourceException;
import com.mediasilo.sdk.rest.resource.Resource;

public class Asset extends Resource<AssetRequest, AssetResponse> {

	public Asset(RestClient restClient) {
		super(restClient, AssetRequest.class, AssetResponse.class);
	}

	/**
	 * Represents the resource path in the MediaSilo API
	 * @return
	 */
	protected String getResourcePath() {
		return "assets";
	}

	/**
	 * Creates a new Asset from a fully hydrated AssetRequest object
	 * @param request A AssetRequest object
	 * @return A response containing the ID of the newly created Asset
	 * @throws com.mediasilo.sdk.rest.resource.MediaSiloResourceException
	 */
	public CreateResponse create(AssetRequest request) throws MediaSiloResourceException {
		return super.create(request, "");
	}


	/**
	 * Creates a new Asset
	 * @param title The title of the new Asset. When creating a QuickLink this will appear in the asset viewer
	 * @param description The description of the new Asset. When creating a QuickLink this will appear in the asset
	 *                       viewer
	 * @param projectId The destination project
	 * @param sourceUrl The location of the asset to be uploaded to MediaSilo
	 * @return A response containing the ID of the newly created Asset
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(String title, String description, String projectId, String sourceUrl) throws
			MediaSiloResourceException {

		return create(new AssetRequest(title, description, projectId, sourceUrl));
	}


	/**
	 * Creates a new Asset
	 * @param title The title of the new Asset. When creating a QuickLink this will appear in the asset viewer
	 * @param description The description of the new Asset. When creating a QuickLink this will appear in the asset
	 *                       viewer
	 * @param projectId The destination project
	 * @param sourceUrl The location of the asset to be uploaded to MediaSilo
	 * @param isPrivate A private asset will have all URLs digitally signed
	 * @return A response containing the ID of the newly created Asset
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(String title, String description, String projectId, String sourceUrl,
								 boolean isPrivate) throws
			MediaSiloResourceException {

		return create(new AssetRequest(title, description, projectId, sourceUrl, isPrivate));
	}

	/**
	 *  Creates a new Asset
	 * @param title The title of the new Asset. When creating a QuickLink this will appear in the asset viewer
	 * @param description The description of the new Asset. When creating a QuickLink this will appear in the asset
	 *                       viewer
	 * @param projectId The destination project within MediaSilo
	 * @param folderId The destination folder within MediaSilo
	 * @param sourceUrl The location of the asset to be uploaded to MediaSilo
	 * @return
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(String title, String description, String projectId,
								 String folderId, String sourceUrl) throws
			MediaSiloResourceException {

		return create(new AssetRequest(title, description, projectId, folderId, sourceUrl));
	}

	/**
	 *  Creates a new Asset
	 * @param title The title of the new Asset. When creating a QuickLink this will appear in the asset viewer
	 * @param description The description of the new Asset. When creating a QuickLink this will appear in the asset
	 *                       viewer
	 * @param projectId The destination project within MediaSilo
	 * @param folderId The destination folder within MediaSilo
	 * @param sourceUrl The location of the asset to be uploaded to MediaSilo
	 * @param isPrivate A private asset will have all URLs digitally signed
	 * @return
	 * @throws MediaSiloResourceException
	 */
	public CreateResponse create(String title, String description, String projectId,
								 String folderId, String sourceUrl, boolean isPrivate) throws
			MediaSiloResourceException {

		return create(new AssetRequest(title, description, projectId, folderId, sourceUrl, isPrivate));
	}

	/**
	 * Get a specific Asset by it's ID
	 * @param id The identifier of the QuickLink to retrieve
	 * @return A QuickLinkResponse
	 * @throws MediaSiloResourceException
	 */
	public AssetResponse read(String id) throws MediaSiloResourceException {
		return get(id, "");
	}

	/**
	 * Update an Asset
	 * @param request A AssetRequest representing the changes to be made. NOTE: This object should have the ID
	 *                   of the target Asset set otherwise no update will be performed.
	 * @throws MediaSiloResourceException
	 */
	public void update(AssetRequest request) throws MediaSiloResourceException {
		super.update(request, "");
	}
}