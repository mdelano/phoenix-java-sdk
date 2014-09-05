package com.mediasilo.sdk.rest.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediasilo.sdk.rest.credentials.BasicAuthenticationCredentials;
import com.mediasilo.sdk.rest.credentials.Credentials;
import com.mediasilo.sdk.rest.credentials.SessionCredentials;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MediaSiloRestClient implements RestClient {

    protected DefaultHttpClient httpClient = new DefaultHttpClient();
	private String baseUrl;
	private Credentials credentials;
	private ObjectMapper mapper;

	public MediaSiloRestClient(String baseUrl) {
		this.mapper = new ObjectMapper();
		this.baseUrl = baseUrl;
	}

	public MediaSiloRestClient(String baseUrl, Credentials credentials) {
		this(baseUrl);
		this.credentials = credentials;
	}

	@Override
	public String get(String relativePath) throws MediaSiloRestClientException {
		String url = baseUrl + relativePath;
		HttpGet get = new HttpGet(url);
		return doRequest(get);
	}

	@Override
	public String delete(String relativePath) throws MediaSiloRestClientException {
		HttpDelete delete = new HttpDelete(baseUrl + relativePath);
		return doRequest(delete);
	}

	@Override
	public <RequestType> String post(String relativePath, RequestType requestEntity) throws MediaSiloRestClientException {
		HttpPost post = new HttpPost(baseUrl + relativePath);
		return requestWithJson(post, requestEntity);
	}

	@Override
	public <RequestType> String put(String relativePath, RequestType requestEntity) throws MediaSiloRestClientException {
		HttpPut put = new HttpPut(baseUrl + relativePath);
		return requestWithJson(put, requestEntity);
	}

	@SuppressWarnings("unchecked")
	private String doRequestReceiveJson(HttpClient httpClient, HttpUriRequest req) throws MediaSiloRestClientException {
		HttpResponse response = null;
		try {
			response = httpClient.execute(req);

			if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300) {
				// get the json out
				HttpEntity body = response.getEntity();
				if (body == null) {
					return null;
				} else {
					final String json = EntityUtils.toString(response.getEntity());
					return json;
				}
			} else if (response.getStatusLine().getStatusCode() == 404) {
				throw new MediaSiloRestClientException("Not found", response);
			} else {
				throw new MediaSiloRestClientException("request returned code " + response.getStatusLine().getStatusCode(), response);
			}
		} catch (IOException e) {
			throw new MediaSiloRestClientException("API request failed {" + req + "}", e, response);
		} finally {
			if (response != null) {
				EntityUtils.consumeQuietly(response.getEntity());
			}
		}
	}

    private String doRequestReceiveJson(HttpUriRequest req) throws
			MediaSiloRestClientException {
        return doRequestReceiveJson(httpClient, req);
    }

	private String requestWithJson(HttpEntityEnclosingRequestBase request,
																	Object requestEntity) throws MediaSiloRestClientException {
		try {
			StringEntity entity = new StringEntity(mapper.writeValueAsString(requestEntity));
			request.setEntity(entity);
		} catch (UnsupportedEncodingException e) {
			throw new MediaSiloRestClientException("Could not convert requestEntity object to JSON", e);
		} catch (JsonProcessingException e) {
			throw new MediaSiloRestClientException("Could not convert requestEntity object to JSON", e);
		}

		return doRequest(request);
	}

	private String doRequest(HttpRequestBase request) throws MediaSiloRestClientException {
		trySetRequestAuthentication(request);

		try {
			return doRequestReceiveJson(request);
		} catch (MediaSiloRestClientException e) {
			return null;
		}
	}

	private void trySetRequestAuthentication(HttpUriRequest request) {
		if(credentials != null) {
			if(credentials instanceof BasicAuthenticationCredentials) {
				String basicAuthEncodedCreds = ((BasicAuthenticationCredentials)credentials).encodeForBasicAuth();
				request.setHeader("Authorization", basicAuthEncodedCreds);
			}
			if(credentials instanceof SessionCredentials) {
				SessionCredentials sessionCreds = ((SessionCredentials)credentials);
				request.setHeader("MediaSiloSessionKey", sessionCreds.getSessionKey());
			}

			request.setHeader("MediaSiloHostContext", credentials.getHostName());
		}
	}

}