package com.base.framework.boot.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = FrameworkCoreProperties.PREFIX)
public class FrameworkCoreProperties {

    static final String PREFIX = "framework.core";

    private Boolean checkApplicationTypeForService = true;

    private Boolean checkApplicationTypeForWeb = true;

    public Boolean getCheckApplicationTypeForService() {
        return checkApplicationTypeForService;
    }

    public void setCheckApplicationTypeForService(Boolean checkApplicationTypeForService) {
        this.checkApplicationTypeForService = checkApplicationTypeForService;
    }

    public Boolean getCheckApplicationTypeForWeb() {
        return checkApplicationTypeForWeb;
    }

    public void setCheckApplicationTypeForWeb(Boolean checkApplicationTypeForWeb) {
        this.checkApplicationTypeForWeb = checkApplicationTypeForWeb;
    }
}
