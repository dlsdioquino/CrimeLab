package com.crimelab.domain;

public class SiteSetting {
    
    private String setting_name;
    private String setting_value;

    public SiteSetting() {
    }

    public SiteSetting(String setting_name, String setting_value) {
        this.setting_name = setting_name;
        this.setting_value = setting_value;
    }

    /**
     * @return the setting_name
     */
    public String getSetting_name() {
        return setting_name;
    }

    /**
     * @param setting_name the setting_name to set
     */
    public void setSetting_name(String setting_name) {
        this.setting_name = setting_name;
    }

    /**
     * @return the setting_value
     */
    public String getSetting_value() {
        return setting_value;
    }

    /**
     * @param setting_value the setting_value to set
     */
    public void setSetting_value(String setting_value) {
        this.setting_value = setting_value;
    }
    
}
