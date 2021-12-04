package com.kolmakova.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataSourceConfigProperties {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    public String getDriverClassName() {
        return driverClassName;
    }
}
