package com.mediasilo.sdk.resources.share;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mediasilo.sdk.resources.share.model.EmailRecipient;
import com.mediasilo.sdk.resources.share.model.EmailShare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShareRequestResponse {

	private String id;
	private String targetObjectId;
	private EmailShare emailShare;
	private Date created;
	private String sharedBy;

	public ShareRequestResponse() {}

	public ShareRequestResponse(String targetObjectId, String subject, String message, String... emailAddresses) {
		List<EmailRecipient> emailRecipientList = new ArrayList<EmailRecipient>();
		for(String emailAddress : emailAddresses) {
			emailRecipientList.add(new EmailRecipient(emailAddress));
		}

		EmailShare emailShare = new EmailShare(emailRecipientList, subject, message);
		this.targetObjectId = targetObjectId;
		this.emailShare = emailShare;
	}

	public ShareRequestResponse(String targetObjectId, String... emailAddresses) {
		this(targetObjectId, "New QuickLink", "A new QuickLink has been shared with you.", emailAddresses);
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