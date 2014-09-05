package com.mediasilo.sdk.resources.asset.model;

import java.util.List;

public interface Derivative {

	public String getType();
    public void setType(String type);
    public String getUrl();
    public void setUrl(String url);
    public Integer getFileSize();
    public void setFileSize(Integer fileSize);
    public Integer getHeight();
    public void setHeight(Integer height);
    public Integer getWidth();
    public void setWidth(Integer width);
    public Integer getDuration();
    public void setDuration(Integer duration);
    public String getThumbnail();
    public void setThumbnail(String thumbnail);
    public String getPosterFrame();
    public void setPosterFrame(String posterFrame);
    public List<Strategy> getStrategies();
    public void setStrategies(List<Strategy> strategies);
    public void addStrategy(Strategy strategy);
}
