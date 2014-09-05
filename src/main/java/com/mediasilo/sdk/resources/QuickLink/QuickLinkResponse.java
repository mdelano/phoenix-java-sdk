package com.mediasilo.sdk.resources.QuickLink;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mediasilo.sdk.resources.QuickLink.model.QuickLinkConfiguration;
import com.mediasilo.sdk.resources.share.ShareRequestResponse;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuickLinkResponse {

	private String id;
	private String legacyUuid;
	private String title;
	private String description;
	private List<String> assetIds;
	private QuickLinkConfiguration configuration;
	private List<ShareRequestResponse> shares;
	private String ownerId;
	private String accountId;
	private Long created;
	private Long modified;
	private Long expires;
	private String url;

	public QuickLinkResponse() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLegacyUuid() {
		return legacyUuid;
	}

	public void setLegacyUuid(String legacyUuid) {
		this.legacyUuid = legacyUuid;
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

	public List<ShareRequestResponse> getShares() {
		return shares;
	}

	public void setShares(List<ShareRequestResponse> shares) {
		this.shares = shares;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Long getModified() {
		return modified;
	}

	public void setModified(Long modified) {
		this.modified = modified;
	}

	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isPrivate() {
		try {
			return configuration.getSetting("audience").equalsIgnoreCase("private");
		}
		catch (NullPointerException e) {
			return false;
		}
	}
}
