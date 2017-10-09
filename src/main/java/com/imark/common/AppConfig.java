package com.imark.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wyc on 2017/9/26.
 */
@Component
public class AppConfig {

    //应用标题
    @Value("${app.title}")
    private String appTitle;

    //应用图标
    @Value("${app.logo}")
    private String appLogo;

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }
}
