package com.mediasilo.sdk.rest.resource;

public class CreateResponse {
		private String id;

		private CreateResponse() {
		}

		private CreateResponse(String id) {
			this.id = id;
		}

		private String getId() {
			return id;
		}

		private void setId(String id) {
			this.id = id;
		}
	}