package com.imark.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wyc on 2017/9/26.
 */
@Component
public class AppConfig {

    @Value("${app.title}")
    private String appTitle;

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }
}
