package com.mediasilo.sdk.resources.asset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetRequest {

    private String id;
    private String projectId;
    private String folderId;
    private String title;
    private String description;
    private String sourceUrl;
	private boolean isPrivate;

	public AssetRequest() {
	}

	public AssetRequest(String title, String description, String projectId, String sourceUrl) {
		this.title = title;
		this.description = description;
		this.projectId = projectId;
		this.sourceUrl = sourceUrl;
	}

	public AssetRequest(String title, String description, String projectId, String sourceUrl, boolean isPrivate) {
		this(title, description, projectId, sourceUrl);

		this.isPrivate = isPrivate;
	}

	public AssetRequest(String title, String description, String projectId, String folderId, String sourceUrl) {
		this(title, description, projectId, sourceUrl);

		this.folderId = folderId;
	}

	public AssetRequest(String title, String description, String projectId, String folderId, String sourceUrl,
						boolean isPrivate) {
		this(title, description, projectId, folderId, sourceUrl);

		this.isPrivate = isPrivate;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
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

    public String getSourceUrl() {
        return sourceUrl;
    }

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean aPrivate) {
		isPrivate = aPrivate;
	}
}
