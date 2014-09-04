package com.mediasilo.sdk.resources.QuickLink.model;

import java.util.List;

public class EmailShare {

	private List<EmailRecipient> audience;
	private String subject;
	private String message;

	public EmailShare() {}

	public EmailShare(List<EmailRecipient> audience, String subject, String message) {
		this.audience = audience;
		this.subject = subject;
		this.message = message;
	}

	public List<EmailRecipient> getAudience() {
		return audience;
	}

	public void setAudience(List<EmailRecipient> audience) {
		this.audience = audience;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
