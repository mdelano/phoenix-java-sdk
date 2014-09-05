package com.mediasilo.sdk.resources.asset.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetStrategy implements Strategy {

    private String type;
	private String url;
    private String streamer;

    public AssetStrategy() {
    }

    public AssetStrategy(String type) {
        this.type = type;
    }

    public AssetStrategy(String type, String url, String streamer) {
        this.type = type;
        this.url = url;
        this.streamer = streamer;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getStreamer() {
        return streamer;
    }

    @Override
    public void setStreamer(String streamer) {
        this.streamer = streamer;
    }
}