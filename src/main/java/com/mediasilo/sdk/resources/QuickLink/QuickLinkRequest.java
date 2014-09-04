package com.mediasilo.sdk.resources.QuickLink;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mediasilo.sdk.resources.QuickLink.model.QuickLinkConfiguration;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuickLinkRequest {

	private String id;
	private String title;
	private String description;
	private List<String> assetIds;
	private QuickLinkConfiguration configuration;
	private Long expires;

	public QuickLinkRequest(String title, String description, List<String> assetIds) {
		this.title = title;
		this.description = description;
		this.assetIds = assetIds;
	}

	public QuickLinkRequest(String title, String description, List<String> assetIds, QuickLinkConfiguration configuration, Long expires) {
		this(title, description, assetIds);

		this.configuration = configuration;
		this.expires = expires;
	}

	public QuickLinkRequest() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

	public QuickLinkConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(QuickLinkConfiguration configuration) {
		this.configuration = configuration;
	}

	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}
}
