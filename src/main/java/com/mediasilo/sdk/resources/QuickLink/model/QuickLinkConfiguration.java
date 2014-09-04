package com.mediasilo.sdk.resources.QuickLink.model;

import java.util.*;

public class QuickLinkConfiguration {

	private String id;

	private List<KeyValueSetting> settings;

	public QuickLinkConfiguration() {}

	public QuickLinkConfiguration(String id, List<KeyValueSetting> settings) {
		this.id = id;
		this.settings = settings;
	}

	public QuickLinkConfiguration(HashMap<String, String> settings) {
		List<KeyValueSetting> keyValueSettings = new ArrayList<KeyValueSetting>();

		for(Map.Entry entry : settings.entrySet()) {
			keyValueSettings.add(new KeyValueSetting(entry.getKey().toString(), entry.getValue().toString()));
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<KeyValueSetting> getSettings() {
		return settings;
	}

	public void setKeyValues(List<KeyValueSetting> settings) {
		this.settings = settings;
	}

    public String getSetting(String key) {
		if (settings != null) {
            for (KeyValueSetting setting : settings)
                if (setting.getKey().equalsIgnoreCase(key))
                    return setting.getValue();
        }

        return "";
    }

    public void addSetting(String key, String value) {
        removeSetting(key); // No duplicate keys allowed!
        if (settings == null)
            settings = new ArrayList<KeyValueSetting>();

        settings.add(new KeyValueSetting(key, value));
    }

    public void removeSetting(String key) {
        if (settings != null) {
            Iterator<KeyValueSetting> iterator = settings.iterator();
            while (iterator.hasNext()) {
                KeyValueSetting setting = iterator.next();
                if (setting.getKey().equalsIgnoreCase(key))
                    iterator.remove();
            }
        }
    }

    public void fixAudienceSetting() {
        if (getSetting("audience") != null) {
            if (getSetting("audience").equalsIgnoreCase("privateiwthguestaccess")){
                addSetting("audience", "password");
            }
        }
    }
}
