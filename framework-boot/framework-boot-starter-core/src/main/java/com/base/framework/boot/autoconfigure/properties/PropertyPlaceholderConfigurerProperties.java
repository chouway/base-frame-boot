package com.base.framework.boot.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = PropertyPlaceholderConfigurerProperties.PREFIX)
public class PropertyPlaceholderConfigurerProperties {

    static final String PREFIX = "framework.properties";

    private String locations;

    private Boolean ignoreResourceNotFound;


    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public Boolean getIgnoreResourceNotFound() {
        return ignoreResourceNotFound;
    }

    public void setIgnoreResourceNotFound(Boolean ignoreResourceNotFound) {
        this.ignoreResourceNotFound = ignoreResourceNotFound;
    }
}
