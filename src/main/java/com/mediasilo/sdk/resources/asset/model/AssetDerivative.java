package com.mediasilo.sdk.resources.asset.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDerivative implements Derivative {

    private String type;
	private String url;
    private Integer fileSize;
    private Integer height;
    private Integer width;
    private Integer duration;
    private String thumbnail;
    private String posterFrame;
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            defaultImpl = AssetStrategy.class,
            property = "type"
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = AssetStrategy.class, name = "rtmp"),
            @JsonSubTypes.Type(value = AssetStrategy.class, name = "rtmpt")
    })
    private List<Strategy> strategies;

    public AssetDerivative() {
    }

    public AssetDerivative(String type) {
        this.type = type;
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
    public Integer getFileSize() {
        return fileSize;
    }

    @Override
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    @Override
    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    @Override
    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public Integer getDuration() {
        return duration;
    }

    @Override
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String getPosterFrame() {
        return posterFrame;
    }

    @Override
    public void setPosterFrame(String posterFrame) {
        this.posterFrame = posterFrame;
    }

    @Override
    public List<Strategy> getStrategies() {
        return strategies;
    }

    @Override
    public void setStrategies(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public void addStrategy(Strategy strategy) {
        if (this.strategies == null)
            strategies = new ArrayList<Strategy>();

        if (!strategies.contains(strategy))
            strategies.add(strategy);
    }
}