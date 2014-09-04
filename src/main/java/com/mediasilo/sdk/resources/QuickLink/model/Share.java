package com.mediasilo.sdk.resources.QuickLink.model;

import com.mediasilo.sdk.resources.QuickLink.model.EmailShare;

import java.util.Date;

public class Share {

	private String id;
	private String targetObjectId;
	private EmailShare emailShare;
	private Date created;
	private String sharedBy;

	public Share() {}

	public Share(String id, String targetObjectId, EmailShare emailShare, Date created, String sharedBy) {
		this.id = id;
		this.targetObjectId = targetObjectId;
		this.emailShare = emailShare;
		this.created = created;
		this.sharedBy = sharedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTargetObjectId() {
		return targetObjectId;
	}

	public void setTargetObjectId(String targetObjectId) {
		this.targetObjectId = targetObjectId;
	}

	public EmailShare getEmailShare() {
		return emailShare;
	}

	public void setEmailShare(EmailShare emailShare) {
		this.emailShare = emailShare;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(String sharedBy) {
		this.sharedBy = sharedBy;
	}
}