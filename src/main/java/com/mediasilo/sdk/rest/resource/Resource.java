package com.mediasilo.sdk.rest.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediasilo.sdk.rest.client.MediaSiloRestClientException;
import com.mediasilo.sdk.rest.client.RestClient;

import java.io.IOException;

/**
 * This class is the base resource class for all MediaSilo API resources. It handles marshaling the resource request
 * and response types for all Create, Read, Update, and Delete operations.
 *
 * @param <Request> The type of the resource request. This is the type that is intended to be sent to the MediaSilo API
 * @param <Response> The type of the resource response. This is the type that is expected back from the MediaSilo API
 */
public abstract class Resource<Request, Response> {

	private RestClient restClient;
	ObjectMapper objectMapper;
	Class<Request> requestType;
	Class<Response> responseType;

	protected Resource(RestClient restClient, Class<Request> requestType, Class<Response> responseType) {
		this.restClient = restClient;
		this.requestType = requestType;
		this.responseType = responseType;
		this.objectMapper = new ObjectMapper();
	}

	protected abstract String getResourcePath();

	/**
	 * Wrapper for a POST request to the MediaSilo API
	 * @param request
	 * @param relativePath If the request is not being made to the root resource path then this parameter will be
	 *                        appended to the request URL
	 * @return An object containing the ID of the newly created object
	 * @throws com.mediasilo.sdk.rest.resource.MediaSiloResourceException
	 */
	protected CreateResponse create(Request request, String relativePath) throws MediaSiloResourceException {
		try {
			String resourcePath = String.format("/%s%s", getResourcePath(), relativePath);
			String json = restClient.post(resourcePath, request);

			return objectMapper.readValue(json, CreateResponse.class);
		}
		catch (MediaSiloRestClientException e) {
			throw new MediaSiloResourceException(e);
		}
		catch (IOException e) {
			throw new MediaSiloResourceException(e);
		}
	}

	/**
	 * Wrapper for a GET request to the MediaSilo API
	 * @param id The Identifier of the resource to be fetched
	 * @param relativePath If the request is not being made to the root resource path then this parameter will be
	 *                        appended to the request URL
	 * @return The resource
	 * @throws MediaSiloRestClientException
	 */
	protected Response get(String id, String relativePath) throws MediaSiloRestClientException {
		try {
			String resourcePath = String.format("/%s%s/%s", getResourcePath(), relativePath, id);
			String json =  restClient.get(resourcePath);

			return objectMapper.readValue(json, responseType);
		}
		catch (MediaSiloRestClientException e) {
			throw new MediaSiloResourceException(e);
		}
		catch (IOException e) {
			throw new MediaSiloResourceException(e);
		}
	}

	/**
	 * Wrapper for a PUT request to the MediaSilo API
	 * @param request
	 * @param relativePath If the request is not being made to the root resource path then this parameter will be
	 *                        appended to the request URL
	 * @throws MediaSiloResourceException
	 */
	protected void update(Request request, String relativePath) throws MediaSiloResourceException {
		try {
			String resourcePath = String.format("/%s%s", getResourcePath(), relativePath);
			restClient.put(resourcePath, request);
		}
		catch (MediaSiloRestClientException e) {
			throw new MediaSiloResourceException(e);
		}
	}

	/**
	 * Wrapper for a DELETE request to the MediaSilo API
	 * @param id The Identifier of the resource to be fetched
	 * @param relativePath If the request is not being made to the root resource path then this parameter will be
	 *                        appended to the request URL
	 * @throws MediaSiloRestClientException
	 */
	protected void delete(String id, String relativePath) throws MediaSiloResourceException {
		try {
			String resourcePath = String.format("/%s%s/%s", getResourcePath(), relativePath, id);
			restClient.delete(resourcePath);
		}
		catch (MediaSiloRestClientException e) {
			throw new MediaSiloResourceException(e);
		}
	}
}
