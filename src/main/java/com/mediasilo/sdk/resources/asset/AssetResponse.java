package com.mediasilo.sdk.resources.asset;

import com.fasterxml.jackson.annotation.*;
import com.mediasilo.sdk.resources.asset.model.AssetDerivative;
import com.mediasilo.sdk.resources.asset.model.AssetTag;
import com.mediasilo.sdk.resources.asset.model.Derivative;
import com.mediasilo.sdk.resources.asset.model.Strategy;
import com.mediasilo.sdk.util.UrlStringUtility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetResponse {

    private String id;
	private String title;
    private String description;
    private String fileName;
    private String projectId;
    private String folderId;
    private String uploadedBy;
    private String approvalStatus;
    private String archiveStatus;
    private String transcriptStatus;
    private String type;
    private Date dateCreated;
    private Date dateModified;
    private Integer progress;
    private Integer commentCount;
    private Float myRating;
    private Float averageRating;
    private Boolean isPrivate;
    private Boolean isExternal;
	private List<String> permissions;
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            defaultImpl = AssetDerivative.class,
            property = "type"
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = AssetDerivative.class, name = "source"),
            @JsonSubTypes.Type(value = AssetDerivative.class, name = "proxy")
    })
    private List<Derivative> derivatives;
    private Set<AssetTag> tags;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getArchiveStatus() {
        return archiveStatus;
    }

    public void setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
    }

    public String getTranscriptStatus() {
        return transcriptStatus;
    }

    public void setTranscriptStatus(String transcriptStatus) {
        this.transcriptStatus = transcriptStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Float getMyRating() {
        return myRating;
    }

    public void setMyRating(Float myRating) {
        this.myRating = myRating;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public Boolean isPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Boolean isExternal() {
        return isExternal;
    }

    public void setIsExternal(Boolean isExternal) {
        this.isExternal = isExternal;
    }

    public Set<AssetTag> getTags() {
        return tags;
    }

    public void setTags(Set<AssetTag> tags) {
        this.tags = tags;
    }

    public List<Derivative> getDerivatives() {
        return derivatives;
    }

    public void setDerivatives(List<Derivative> derivatives) {
        this.derivatives = derivatives;
    }

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	@JsonIgnore
    public Derivative getDerivative(String type) {
        if (derivatives != null)
            for (Derivative derivative : derivatives)
                if (derivative.getType().equalsIgnoreCase(type))
                    return derivative;
        return null;
    }

    @JsonIgnore
    public void addDerivative(Derivative derivative) {
        if (derivatives == null)
            this.derivatives = new ArrayList<Derivative>();

        derivatives.add(derivative);
    }

    @JsonIgnore
    public void removeDerivative(Derivative derivative) {
        if (derivative != null && derivatives.contains(derivative))
            derivatives.remove(derivative);
    }

    @JsonIgnore
    public void removeDerivative(String type) {
        removeDerivative(getDerivative(type));
    }

    @JsonIgnore
    public Strategy getStrategy(String type) {
        for (Derivative derivative : derivatives)
            if (derivative.getStrategies() != null && !derivative.getStrategies().isEmpty())
                for (Strategy strategy : derivative.getStrategies())
                    if (strategy.getType().equalsIgnoreCase(type))
                        return strategy;
        return null;
    }

    @JsonIgnore
    public String getSourceFilename() {
        return UrlStringUtility.extractFileName(getDerivative("source").getUrl());
    }

    @JsonIgnore
    public String getSourceFileExtension() {
        return UrlStringUtility.extractFileExtension(getDerivative("source").getUrl());
    }
}