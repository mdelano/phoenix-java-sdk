package com.mediasilo.sdk.resources.asset.model;

public class AssetTag {

    private Integer id;
    private String name;

    public AssetTag() {}

    public AssetTag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
