package com.mediasilo.sdk.rest.resource;

public class CreateResponse {
		private String id;

		private CreateResponse() {
		}

		public CreateResponse(String id) {
			this.id = id;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}