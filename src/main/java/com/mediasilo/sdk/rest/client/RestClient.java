package com.mediasilo.sdk.rest.client;

public interface RestClient {

	/**
	 * REST GET Request
	 * @param relativePath If present, this path will be appended to the base URL
	 * @return JSON
	 * @throws RestClientException
	 */
	String get(String relativePath) throws RestClientException;

	/**
	 * REST DELETE Request
	 * @param relativePath If present, this path will be appended to the base URL
	 * @return JSON
	 * @throws RestClientException
	 */
	String delete(String relativePath) throws RestClientException;

	/**
	 * REST POST Request
	 * @param relativePath If present, this path will be appended to the base URL
	 * @param requestEntity The object to be serialized as the request payload
	 * @return JSON
	 * @throws RestClientException
	 */
	<RequestType> String post(String relativePath, RequestType requestEntity) throws RestClientException;

	/**
	 * REST PUT Request
	 * @param relativePath If present, this path will be appended to the base URL
	 * @param requestEntity The object to be serialized as the request payload
	 * @return JSON
	 * @throws RestClientException
	 */
	<RequestType> String put(String relativePath, RequestType requestEntity) throws RestClientException;

}
