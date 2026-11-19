package com.itm.utils;

import java.util.Properties;

public class ConfigReader {

    Properties properties;

    public ConfigReader() {
        properties = new Properties();
    }

    public String getUrl() {
        return properties.getProperty("url");
    }
}