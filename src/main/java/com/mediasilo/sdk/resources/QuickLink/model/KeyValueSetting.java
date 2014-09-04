package com.mediasilo.sdk.resources.QuickLink.model;

public class KeyValueSetting {

    private String key;

    private String value;

    public KeyValueSetting(String key, String value) {
		this.key = key;
        this.value = value;
    }

    public KeyValueSetting() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof KeyValueSetting){
            KeyValueSetting kvs=(KeyValueSetting)obj;
            return this.key.toLowerCase().equals(kvs.getKey().toLowerCase());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
